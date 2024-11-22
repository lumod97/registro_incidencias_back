package com.cpiura.catics.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "glpi_users")
public class GlpiUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String password;

    @Column(name = "password_last_update")
    private Timestamp passwordLastUpdate;

    @Column(length = 255)
    private String phone;

    @Column(length = 255)
    private String phone2;

    @Column(length = 255)
    private String mobile;

    @Column(length = 255)
    private String realname;

    @Column(length = 255)
    private String firstname;

    @Column(name = "locations_id", nullable = false, columnDefinition = "int default 0")
    private Integer locationsId;

    @Column(length = 10)
    private String language;

    @Column(name = "use_mode", nullable = false, columnDefinition = "int default 0")
    private Integer useMode;

    @Column(name = "list_limit")
    private Integer listLimit;

    @Column(name = "is_active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private Boolean isActive;

    @Column(columnDefinition = "text")
    private String comment;

    @Column(name = "auths_id", nullable = false, columnDefinition = "int default 0")
    private Integer authsId;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer authtype;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "date_mod")
    private Timestamp dateMod;

    @Column(name = "date_sync")
    private Timestamp dateSync;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isDeleted;

    @Column(name = "profiles_id", nullable = false, columnDefinition = "int default 0")
    private Integer profilesId;

    @Column(name = "entities_id", nullable = false, columnDefinition = "int default 0")
    private Integer entitiesId;

    @Column(name = "usertitles_id", nullable = false, columnDefinition = "int default 0")
    private Integer usertitlesId;

    @Column(name = "usercategories_id", nullable = false, columnDefinition = "int default 0")
    private Integer usercategoriesId;

    @Column(name = "date_format")
    private Integer dateFormat;

    @Column(name = "number_format")
    private Integer numberFormat;

    @Column(name = "names_format")
    private Integer namesFormat;

    @Column(name = "csv_delimiter", length = 1)
    private String csvDelimiter;

    @Column(name = "is_ids_visible")
    private Boolean isIdsVisible;

    @Column(name = "use_flat_dropdowntree")
    private Boolean useFlatDropdowntree;

    @Column(name = "show_jobs_at_login")
    private Boolean showJobsAtLogin;

    @Column(name = "priority_1", length = 20)
    private String priority1;

    @Column(name = "priority_2", length = 20)
    private String priority2;

    @Column(name = "priority_3", length = 20)
    private String priority3;

    @Column(name = "priority_4", length = 20)
    private String priority4;

    @Column(name = "priority_5", length = 20)
    private String priority5;

    @Column(name = "priority_6", length = 20)
    private String priority6;

    @Column(name = "followup_private")
    private Boolean followupPrivate;

    @Column(name = "task_private")
    private Boolean taskPrivate;

    @Column(name = "default_requesttypes_id")
    private Integer defaultRequesttypesId;

    @Column(name = "password_forget_token", length = 40)
    private String passwordForgetToken;

    @Column(name = "password_forget_token_date")
    private Timestamp passwordForgetTokenDate;

    @Column(name = "user_dn", columnDefinition = "text")
    private String userDn;

    @Column(name = "registration_number", length = 255)
    private String registrationNumber;

    @Column(name = "show_count_on_tabs")
    private Boolean showCountOnTabs;

    @Column(name = "refresh_views")
    private Integer refreshViews;

    @Column(name = "set_default_tech")
    private Boolean setDefaultTech;

    @Column(name = "personal_token", length = 255)
    private String personalToken;

    @Column(name = "personal_token_date")
    private Timestamp personalTokenDate;

    @Column(name = "api_token", length = 255)
    private String apiToken;

    @Column(name = "api_token_date")
    private Timestamp apiTokenDate;

    @Column(name = "cookie_token", length = 255)
    private String cookieToken;

    @Column(name = "cookie_token_date")
    private Timestamp cookieTokenDate;

    @Column(name = "display_count_on_home")
    private Integer displayCountOnHome;

    @Column(name = "notification_to_myself")
    private Boolean notificationToMyself;

    @Column(name = "duedateok_color", length = 255)
    private String duedateokColor;

    @Column(name = "duedatewarning_color", length = 255)
    private String duedatewarningColor;

    @Column(name = "duedatecritical_color", length = 255)
    private String duedatecriticalColor;

    @Column(name = "duedatewarning_less")
    private Integer duedatewarningLess;

    @Column(name = "duedatecritical_less")
    private Integer duedatecriticalLess;

    @Column(name = "duedatewarning_unit", length = 255)
    private String duedatewarningUnit;

    @Column(name = "duedatecritical_unit", length = 255)
    private String duedatecriticalUnit;

    @Column(name = "display_options", columnDefinition = "text")
    private String displayOptions;

    @Column(name = "is_deleted_ldap", nullable = false, columnDefinition = "tinyint(1) default 0")
    private Boolean isDeletedLdap;

    @Column(name = "pdffont", length = 255)
    private String pdffont;

    @Column(name = "picture", length = 255)
    private String picture;

    @Column(name = "begin_date")
    private Timestamp beginDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "keep_devices_when_purging_item")
    private Boolean keepDevicesWhenPurgingItem;

    @Column(name = "privatebookmarkorder", columnDefinition = "longtext")
    private String privateBookmarkOrder;

    @Column(name = "backcreated")
    private Boolean backCreated;

    @Column(name = "task_state")
    private Integer taskState;

    @Column(name = "layout", length = 20)
    private String layout;

    @Column(name = "palette", length = 20)
    private String palette;

    @Column(name = "set_default_requester")
    private Boolean setDefaultRequester;

    @Column(name = "lock_autolock_mode")
    private Boolean lockAutoLockMode;

    @Column(name = "lock_directunlock_notification")
    private Boolean lockDirectUnlockNotification;

    @Column(name = "date_creation")
    private Timestamp dateCreation;

    @Column(name = "highcontrast_css", columnDefinition = "tinyint(1) default 0")
    private Boolean highContrastCss;

    @Column(name = "plannings", columnDefinition = "text")
    private String plannings;

    @Column(name = "sync_field", length = 255)
    private String syncField;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private Integer groupsId;

    @Column(name = "users_id_supervisor", nullable = false, columnDefinition = "int default 0")
    private Integer usersIdSupervisor;

    @Column(length = 50)
    private String timezone;

    @Column(name = "default_dashboard_central", length = 100)
    private String defaultDashboardCentral;

    @Column(name = "default_dashboard_assets", length = 100)
    private String defaultDashboardAssets;

    @Column(name = "default_dashboard_helpdesk", length = 100)
    private String defaultDashboardHelpdesk;

    @Column(name = "default_dashboard_mini_ticket", length = 100)
    private String defaultDashboardMiniTicket;
}