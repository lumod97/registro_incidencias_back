WITH ResolutoresCTE AS (
    SELECT 
        d.tickets_id, 
        d.users_id,
        (SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = d.users_id) AS Name_Resolutor,
        ROW_NUMBER() OVER (PARTITION BY d.tickets_id ORDER BY d.users_id) AS rn
    FROM glpi_tickets_users d
    WHERE d.type = 2
),
LogAssignmentsCTE AS (
    SELECT 
        log.items_id, 
        log.itemtype_link,
        log.user_name,
        log.date_mod,
        log.new_value
    FROM glpi_logs log
    WHERE log.itemtype_link in ('Group','User')
)
SELECT 
    a.id AS Catic,
    a.name AS Detalle,
    a.date AS Ingreso,
    COALESCE((SELECT max(date_mod) FROM LogAssignmentsCTE where items_id=a.id and itemtype_link='Group' and new_value like '%(6)%'),a.date) AS Asignación, 
    (CASE 
        WHEN a.priority = 5 THEN 'Alta (P2)'
        WHEN a.priority = 6 THEN 'Crítico (P1)'
        WHEN a.priority = 3 THEN 'Baja (P4)'
        WHEN a.priority = 4 THEN 'Media (P3)'
    END) AS Prioridad,
    (CASE 
        WHEN a.status = 1 THEN 'NUEVO' 
        WHEN a.status = 2 THEN 'ASIGNADO' 
        WHEN a.status = 3 THEN 'EN CURSO'
        WHEN a.status = 4 THEN 'PENDIENTE' 
        WHEN a.status = 5 THEN 'RESUELTO'
        WHEN a.status = 6 THEN 'CERRADO'
        WHEN a.status = 13 THEN 'CANCELADO'
    END) AS Estado,    
    (CASE 
        WHEN a.type = 1 THEN 'Incidencia'
        WHEN a.type = 2 THEN 'Solicitud'
    END) AS Tipo,
    COALESCE((SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
        (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%revisión y análisis del problema%' AND date = 
            (SELECT MAX(date) FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%revisión y análisis del problema%')
        ))
    ,(MAX(CASE WHEN r.rn = 1 THEN r.Name_Resolutor END))) AS User_DEV,
    COALESCE(
    COALESCE((SELECT MAX(date) FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%revisión y análisis del problema%'),
    (SELECT max(date_mod) FROM LogAssignmentsCTE where items_id=a.id and itemtype_link='User' and UCASE(new_value) like CONCAT('%',(MAX(CASE WHEN r.rn = 1 THEN r.Name_Resolutor END)),'%'))),a.date) AS Fec_DEV,
    (SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
        (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%prueba%' AND DATE=(SELECT MAX(DATE) FROM glpi_tickettasks WHERE tickets_id =a.id AND LCASE(content) LIKE '%prueba%'))
    ) AS User_QA,
    (SELECT date FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%prueba%' AND DATE=(SELECT MAX(DATE) FROM glpi_tickettasks WHERE tickets_id =a.id AND LCASE(content) LIKE '%prueba%')) AS Fec_QA,
    COALESCE((SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
        (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND UCASE(content) LIKE '%RFC%' AND DATE=(SELECT MAX(DATE) FROM glpi_tickettasks WHERE tickets_id =a.id AND UCASE(content) LIKE '%RFC%'))
    ),(SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID =(SELECT users_id FROM glpi_itilfollowups WHERE items_id = a.id AND UCASE(content) LIKE '%RFC%' AND date = (SELECT MAX(date) FROM glpi_itilfollowups WHERE items_id = a.id)))) 
    AS User_CC,
    COALESCE((SELECT date FROM glpi_tickettasks WHERE tickets_id = a.id AND UCASE(content) LIKE '%RFC%' AND DATE=(SELECT MAX(DATE) FROM glpi_tickettasks WHERE tickets_id =a.id AND UCASE(content) LIKE '%RFC%')),
    (SELECT date FROM glpi_itilfollowups WHERE items_id = a.id AND UCASE(content) LIKE '%RFC%' AND date = (SELECT MAX(date) FROM glpi_itilfollowups WHERE items_id = a.id)))AS Fec_CC,
    COALESCE(
    (CASE WHEN a.status IN (5, 6, 13) THEN(MAX(CASE WHEN r.rn = 1 THEN r.Name_Resolutor END))END)) AS USER_PROD,
    COALESCE(
    COALESCE(
        (CASE WHEN a.status IN (5, 6, 13) THEN (SELECT MAX(date) FROM glpi_itilfollowups WHERE items_id = a.id)
        END)),
        (CASE WHEN a.status IN (5, 6, 13) THEN a.date_mod END)) AS FEC_PROD,
    (CASE 
        WHEN a.status IN (5, 6, 13) THEN 'PROD'
        WHEN COALESCE((SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
           (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND UCASE(content) LIKE '%RFC%')), '') <> '' THEN 'CC'
        WHEN COALESCE((SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
            (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%prueba%' AND DATE=(SELECT MAX(DATE) FROM glpi_tickettasks WHERE tickets_id =a.id AND LCASE(content) LIKE '%prueba%'))), '') <> '' THEN 'QA'
        WHEN COALESCE((SELECT UCASE(CONCAT(realname, ' ', firstname)) FROM glpi_users WHERE ID = 
            (SELECT users_id FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%revisión y análisis del problema%' AND date = 
            (SELECT MAX(date) FROM glpi_tickettasks WHERE tickets_id = a.id AND LCASE(content) LIKE '%revisión y análisis del problema%'))), '') <> '' THEN 'DEV'
        WHEN MAX(CASE WHEN r.rn = 1 THEN r.users_id END)= 98 THEN 'Sin Asignar'
        ELSE 'DEV'
    END) AS Bandeja,
    (SELECT causadeincidentepasefield FROM glpi_plugin_fields_ticketadecuacionincidencias WHERE items_id = a.id) AS Garantía,
    e.completename AS Category
FROM glpi_tickets a
INNER JOIN glpi_groups_tickets b ON b.tickets_id = a.id
INNER JOIN glpi_groups c ON c.id = b.groups_id
INNER JOIN glpi_itilcategories e ON e.id = a.itilcategories_id
LEFT JOIN ResolutoresCTE r ON r.tickets_id = a.id
WHERE c.id = 6
  AND a.date >= '2021-09-01'
  AND a.is_deleted = 0
GROUP BY a.id, a.name, a.date, a.date_mod, a.status, a.priority, a.type, e.completename, a.users_id_lastupdater;