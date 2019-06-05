package com.medicine.exception;


import com.medicine.util.ErrorMessagePropertiesUtil;

public enum ErrorCode {
    AUTHORITY_ERROR(403, 1000, "权限不够"),
    INTERNAL_ERROR(500, 1000, "Internal Server Error."), //
    AUTHTOKEN_ERROR(401, 2000, "AuthToken Error or Expired."), //
    CAPTCHA_ERROR(400, 2010, "CAPTCHA ERROR."), //
    HEALTH_GROUP_ID_ERROR(400, 3019, "Health Group Id is ERROR."), //
    DOCTOR_TYPE_ERROR(400, 3012, "Account type is null or error."), //
    DOCTOR_INFO_EMPTY(400, 5000, ""), //
    DOCTOR_ICON_EMPTY(400, 5001, ""), //
    HEALTH_GROUP_NAME_EMPTY(400, 5002, ""), //
    HEALTH_GROUP_LOGO_EMPTY(400, 5003, ""), //
    HEALTH_GROUP_INFO_EMPTY(400, 5004, ""), //
    HEALTH_GROUP_DETAIL_EMPTY(400, 5005, ""), //
    HEALTH_GROUP_FEE_EMPTY(400, 5006, ""), //
    HEALTH_GROUP_ASSTANT_EMPTY(400, 5007, ""), //
    HEALTH_GROUP_AREA_EMPTY(400, 5008, ""), //
    HEALTH_GROUP_SALESREP_EMPTY(400, 5009, ""), //
    HEALTH_GROUP_CITY_EMPTY(400, 5010, ""), //
    HEALTH_GROUP_NOT_EXIST(400, 5011, ""), //
    HEALTH_GROUP_DOC_TYPE_ERROR(400, 5012, ""), //
    HEALTH_GROUP_ONLY_ONE_ASSISST(400, 5013, ""), //
    HEALTH_GROUP_HEADER_EMPTY(5014), //
    HEALTH_GROUP_EXPERT_EMPTY(5030), //
    HEALTH_GROUP_ASSIST_EMPTY(5031), //
    HEALTH_GROUP_NAME_DUPLICATE(5032), //
    HEALTH_GROUP_FEE_LESS_THAN_1(5033), //
    HEALTH_GROUP_EXPIRED(5034), //
    MEDICAL_HISTORY_TOO_LONG(5035),//
    HOPE_HELP_TOO_LONG(5036),//
    HEALTH_GROUP_DOC_NOT_MATCH(400, 5015, ""), //
    OLD_PASSWORD_ERROR(400, 3010, ""), //
    EXCLUSIVE_CONSULT_PEOPLE_LESS_GREAT_1(5016), //
    EXCLUSIVE_CONSULT_START_TIME_LESS_THAN_24_HOURS(5017), //
    EXCLUSIVE_CONSULT_START_TIME_AFTER_END_TIME(5018), //
    EXCLUSIVE_CONSULT_ID_ERROR(5019), //
    EXCLUSIVE_CONSULT_UPDATE_PEOPLE_LESS_THAN_RESERVED(5020), //
    EXCLUSIVE_CONSULT_BEANS_LESS_THAN_1(5021), //
    EXCLUSIVE_CONSULT_BEANS_NOT_CONFIG(5022), //
    EXCLUSIVE_CONSULT_ASSISSTANT_CANNOT_CREATE(5023), //
    EXCLUSIVE_CONSULT_LEFT_DOCCANNOT_CREATE(5024), //
    EXCLUSIVE_CONSULT_RESERVE_FULL(5025), //
    EXCLUSIVE_CONSULT_REPEAT_RESERVE(5026), //
    EXCLUSIVE_CONSULT_TO_START_TIME(5027), //
    EXCLUSIVE_CONSULT_CANNOT_BE_UPDATED(5028), //
    EXCLUSIVE_CONSULT_WITHOUT_HEALTH_GROUP(5029),//

    ONLY_HEADER_DOC_MODIFY_WARNING_DATA(5100), //

    NOT_EXIST_CONSULTATION(5200), //

    USERNAME_PATTERN_ERROR(400, 3001, "Username is null or error."), //
    SQL_NOT_CONTAINS_SELECT(400, 10036, "SQL is not contains SELECT."), //
    PASSWORD_PATTERN_ERROR(400, 3002, ""), //
    REAL_NAME_ERROR(400, 3003, "Realname is null or error"), //
    PHONE_FORMAT_INVALID(400, 3006, "Phone number format error."), //
    ID_CARD_NUMBER_ERROR(400, 3007, "Id card number is null or error."), //
    EMAIL_FORMAT_ERROR(400, 3011, "Email format is error."), //
    BIRTHDAY_ERROR(400, 3013, "Birthday is null or error."), //
    ACCOUNT_NAME_USED(401, 3014, "Account name has been used."), //
    GENDER_ERROR(400, 3015, "Gender is null or error."), //
    CITY_ID_ERROR(400, 3016, "City iD is null or error."), //
    SAFE_QUESTION_NULL(400, 3024, "Safe question is null."), //
    SAFE_ANSWER_NULL(400, 3025, "Safe answer is null."), //
    BACKUP_PHONE_NUM_ERROR(400, 3017, "Backup phone number format is error."), //
    CUSTOMER_OCCUPATION_NULL(3200), //
    CUSTOMER_HEIGHT_ERROR(3201), //
    CUSTOMER_WEIGHT_ERROR(3202), //
    CUSTOMER_ICON_NULL(3203), //
    ACCOUNT_OR_PHONE_ERROR(3031), //
    CHECK_SAFE_QUETION_ERROR(400, 3032, "Check safe question is error."), //
    CHECK_SAFE_ANSWER_ERROR(400, 3034, "Check safe answer is error."), //
    BEANS_BALANCE_NOT_ENOUGH(400, 3055, "Your beans are not enough."), //

    DATE_FORMAT_ERROR(400, 9000, "Date format is error."), //

    START_CANNOT_END_AFTER(5300),//
    ONLY_CAN_REPLY_SELF_ADVICE(5400),//
    CANNOT_PUBLISH_MESSAGE(5500),//
    NOT_HEADER_CANNOT_ADVICE(5600),//
    ONLY_ASSIST_CAN_DO_THIS(5700),//
    ONLY_APPOINTED_EXPERT_CAN_DO_THIS(5701),//
    CONSULT_HAS_BEEN_ADDED_DISCUSS_GROUP(5702),//
    ONLY_FINISHED_OFFLINE_CAN_UPLOAD(5800),//
    NOT_SAME_GROUP_DOCTOR(5900),//
    CHECK_DATE_CANNOT_NOW_BEFORE(6000),//
    FOLLOW_UP_DATE_CANNOT_NOW_BEFORE(6001),//
    NOT_YOUR_CONSULT_CANNOT_FOLLOWUP(6002),//
    REPEAT_JOINED_SAME_HEALTH_GROUP(6010),//

    MEDICAL_HEALTH_INFO_TOO_LONG(6020),//
    INFECTION_HEALTH_INFO_TOO_LONG(6021),//
    TRAUMA_HEALTH_INFO_TOO_LONG(6022),//
    OPERATION_HEALTH_INFO_TOO_LONG(6023),//
    PREGNANCY_HEALTH_INFO_TOO_LONG(6024),//
    MENSTRUATION_HEALTH_INFO_TOO_LONG(6025),//
    ALLERGIC_HEALTH_INFO_TOO_LONG(6026),//
    BLOOD_HEALTH_INFO_TOO_LONG(6027),//
    FAMILY_MEDICAL_HEALTH_INFO_TOO_LONG(6028),//
    CURRENT_HEALTH_INFO_TOO_LONG(6029),//
    OTHERS_HEALTH_INFO_TOO_LONG(6030),//
    CUSTOMER_CHECK_INFO_WITHOUT_HEALTH_GROUP(6031),//
    NO_HEALTH_CHECK_INFO_UPLOAD(6032),//
    TITLE_BLANK_OR_OVER_MAX_TITLE_LEN(6040),//
    CONTENT_BLANK_OR_OVER_MAX_CONTENT_LEN(6041),//

    ONLY_MAIN_DOCTOR_CAN_DO_IT(6050),//
    ADMIN_USER_NAME_REPEAT(10030),//
    ADMIN_INFORMATION_ISNOTNULL(10031),//
    ADMIN_INADEQUATE_PERMISSION(10032),//
    CUSTOMER_IDNUMBER_REPEAT(10033),//

    USERNAME_ILLEGAL_CHARS(400, 3000, "Username contains illegal chars."), //
    USERNAME_USED(400, 3004, "Account name has been used."), //
    PHONE_REGISTERED(400, 3005, "Phone number has been registered."), //
    NOT_EXIST_ACCOUNT(400, 3008, "Account doesn't exist."), //
    USERNAME_OR_PASSWORD_ERROR(400, 3009, "Username or Password error."), //
    USERNAME_LOCKING(10037),
    PASSWORD_ERROR(10038),

    ID_CARD_PIC_NULL(400, 3022, "Id card pic is null."), //
    FROZE_USER(400, 3033,
            "Your account has been froze. Please contact the administrator."), //
    DOCTOR_ID_ERROR(400, 3035, "Doctor id is null or error."), //
    DOCTOR_AND_DEPT_NOT_MATCH(400, 3036, "Doctor and dept are not match."), //
    JOB_TITLE_ID_ERROR(400, 3037, "Doctor job title id error."), //
    DOCTOR_NOT_PASS(400, 3038, "New doctor didn't pass checking."), //
    NEW_DOCTOR_CHECKING(400, 3039, "New doctor is checking..."), //

    IMAGE_TOO_BIG(400, 3040, "Image size is great than 1M."), //

    NO_ADVICE_RECORD_ERROR(400, 3052, "You don't have any advice record."), //
    ADVICE_SUBJECT_ERROR(400, 3053, "Title cannot be null or max len is 256"), //
    ADVICE_CONTENT_ERROR(400, 3054, "Content cannot be null or max len is 2048"), //

    FLOWERS_NOT_ENOUGH(400, 3056, "Your flowers is not enough."), //
    NOT_ADVICE_OF_CUSTOMER(400, 3057, "Not the customer's common advice"), //

    NOT_EXIST_HEALTH_ADVICE(400, 3070, "Medical Advice id is error."), //
    CONSULT_NOT_MATCH_DOC(400, 3071, "Docotr, the consult doesn't assign you."), //
    CONSULT_NOT_MATCH_CUSTOMER(400, 3072, "You didn't ask the consult."), //
    CONSULT_REPLY_ID_ERROR(400, 3073, "Medical Advice Reply id is error."), //
    CONSULT_PROCESSED(400, 3074,
            "Your consult has been processed, cannot be canceled."), //
    CONSULT_NOT_EXPIRED(400, 3075,
            "Your consult doesn't expire, cannot be canceled."), //

    BUY_COIN_LESS_THAN_10(400, 3090, "Buying coin is less than 10."), //
    ORDER_NO_NOT_EXIST(400, 3091, "The order no doesn't exist."), //

    DIAGNOSISED_HOSPITAL_NOT_EXIST(400, 3100,
            "The diagnosed hospital doesn't exist"), //
    HOSPITAL_DEPT_CANNOT_NULL(400, 3101,
            "The hospital and dept name cannot be empty"), //
    TREATED_RECORD_NOT_EXIST(400, 3102, "The treated record doesn't exist"), //
    TREATED_RECORD_FIELDS_NULL(400, 3103,
            "All fields of  treated record cannot be null."), //
    MEDICINE_RECORD_NOT_EXIST(400, 3104, "The medicine record doesn't exist"), //
    MEDICINE_RECORD_FIELDS_NULL(400, 3105,
            "All fields of medicine record cannot be null."), //
    REPORT_RECORD_NOT_EXIST(400, 3106, "The report record doesn't exist"), //
    REPORT_RECORD_FIELDS_NULL(400, 3107,
            "All fields of report record cannot be null."), //
    HELP_RECORD_NOT_EXIST(400, 3108, "The hope help record doesn't exist"), //
    ILL_DETAIL_FIELD_ERROR(400, 3109,
            "Ill detail field cannot be null and length is 10 -- 1000."), //
    HELP_FIELD_ERROR(400, 3110,
            "Help field cannot be null and length is 10 -- 1000."), //

    DOCTOR_DOES_NOT_ACCEPT_DIAGNOSIS(400, 3111,
            "The doctor doesn't accept diagnosis now"), //
    DOCTOR_DOES_NOT_ACCEPT_DIAGNOSIS_AGAIN(400, 3112,
            "The doctor doesn't accept diagnosis again now"), //

    HOPE_HELP_FILEDS_NULL(400, 3113, "All fields of hope help cannot be null."), //

    ADD_INFO_FIELD_ERROR(400, 3114,
            "Add info cannot be null and max length is 500, min lenght is 10."), //

    DOCTOR_PROCESS_NULL(400, 3120, "Doctor process result is null"), //
    DOCTOR_PROCESS_TYPE_ERROR(400, 3121, "Doctor process type is error"), //

    DOCTOR_NOT_EXIST(400, 3130, "Doctor doesn't exist"), //
    CUSTOMER_NOT_EXIST(3131), //
    CUSTOMER_NOT_SAME_GROUP_WITH_ASSIST(3132),//

    DATE_ORDER_ERROR(400, 8000, "Start date cannot be after end date"), //

    FAQ_Q_NULL(400, 8100, "Faq question is empty."), //
    FAQ_A_NULL(400, 8101, "Faq answer is empty."), //
    FAQ_NOT_EXIST(400, 8102, "Faq doesn't exist."), //

    PROVINCE_ID_ERROR(400, 9001, "Province Id is error."), //
    CITY_EXISTED(400, 9002, "The city has existed."), //
    CITY_NAME_EMPTY(400, 9003, "The city name cannot be empty."), //

    BULLETING_TITLE_ERROR(400, 9010, "The bulletin title is empty or too long."), //
    BULLETING_CONTENT_ERROR(400, 9011,
            "The bulletin content is empty or too long."), //
    BULLETING_TYPE_ERROR(400, 9012, "The bulletin type is error."), //
    BULLETING_ID_ERROR(400, 9013, "The bulletin id is error."), //

    DEPT_NAME_EMPTY(400, 9020, "The department name is empty."), //
    DEPT_NAME_EXIST(400, 9021, "The department has already existed."), //
    DEPT_NOT_EXIST(400, 9022, "The department doesn't exist."), //
    DEPT_FIELD_NOT_EXIST(400, 9023, "The department field doesn't exist."), //

    HOSP_NAME_EMPTY(400, 9030, "The hosptial name is empty."), //
    HOSP_NAME_EXIST(400, 9031, "The hosptial has already existed."), //
    HOSP_NOT_EXIST(400, 9032, "The hosptial doesn't exist."), //
    HOSP_LEVEL_ID_ERROR(400, 9033, "The hospital level id is error."), //

    USER_ID_ERROR(400, 9035, "The user id is error."), //

    DOC_INFO_EMPTY_OR_TOO_LONG(9040), //

    SALES_REP_ID_ERROR(400, 9050, "The sales rep id is error."), //
    SALES_AREA_EXISTED(400, 9051, "The sales area name has existed."), //
    SALES_AREA_ID_ERROR(400, 9052, "The sales area id is error."), //
    SALES_REP_ID_NUM_DUPLICATE(400, 9055, "The sales rep id number duplicate."), //
    SALES_REP_HAS_DOCTOR(400, 9056,
            "The sales rep has doctors, cannot be deleted."), //

    ARTICLE_TITLE_ERROR(400, 9060, "The article title is empty or too long."), //
    ARTICLE_CONTENT_ERROR(400, 9061,
            "The article content is empty or too long."), //
    ARTICLE_TYPE_ERROR(400, 9062, "The article type is error."), //
    ARTICLE_ID_ERROR(400, 9063, "The article id is error."), //

    CUSTOMER_LEVEL_ID_ERROR(400, 9070, "The customer level id is error."), //
    CUSTOMER_LEVEL_VALUE_ERROR(400, 9071,
            "The customer level coin is out of range."), //
    CUSTOMER_LEVEL_GIVE_COIN_LESS_THNA_0(400, 9072,
            "The customer level give coin cannot be less than 0"), //
    CUSTOMER_LEVEL_GIVE_FLOWERS_LESS_THNA_0(400, 9073,
            "The customer level give flowers cannot be less than 0"), //

    DOCTOR_LEVEL_ID_ERROR(400, 9075, "The doctor level id is error."), //
    DOCTOR_LEVEL_VALUE_ERROR(400, 9076,
            "The doctor level points is out of range."), //

    GIVE_COIN_LESS_THNA_0(400, 9080, "The give coin cannot be less than 0"), //
    GIVE_FLOWERS_LESS_THNA_0(400, 9081,
            "The give flowers cannot be less than 0"), //
    GIVE_OFFER_RECHARGE_LIMIT_LESS_THNA_0(400, 9082,
            "The give offer recharge limit cannot be less than 0"), //


    ADD_BEANS_ERROR(9980),//

    OFFER_ID_ERROR(400, 9987, "The special offer id error"), //
    OFFER_DATE_RANGE_ERROR(400, 9989,
            "The special offer start date and end date range error"), //
    OFFER_DATE_RANGE_OVERLAP(
            400,
            9988,
            "The special offer start date and end date range is overlap with other special offer."), //
    ONLINE_CANCELD_BY_CUSTOMER(400, 9991,
            "The customer has canceld the consultation."), //
    ONLINE_DOCTOR_CONSULTING(400, 9992, "The docting is consulting."), //
    ONLINE_CONTENT_EMPTY(400, 9993, "The consult content cannot be empty."), //
    ONLINE_CUSTOMER_NOT_MATCH(400, 9994, "The consult customer doesn't match"), //
    ONLINE_LEVEL_NOT_MATCH(400, 9995, "The consult level doesn't match"), //
    ONLINE_CITY_NOT_MATCH(400, 9996, "The consult city doesn't match"), //
    ONLINE_DEPT_NOT_MATCH(400, 9997, "The consult dept doesn't match"), //
    ONLINE_CONSULT_NOT_EXIST(400, 9998, "The consult doesn't exist"), //
    ONLINE_CUSTOMER_ACCEPTED(400, 9999,
            "The customer has been consulted by other doctor."), //

    NOT_DEFINE_ERROR(400, 10000, "Not defined error."),

    NOT_EXIST_DEVICE(400, 10001, "Device doesn't exist."),
    LOGIN_TYPE_UNKNOWN(400, 10002, "Unknown login type."),
    ID_CARD_REGISTERED(400, 10003, "IDCard number has been registered."),
    NOT_EXIST_EXAM_LIMITATION(400, 10004, "Exam limitation doesn't exist."),
    HAVE_UNKNOWN_EXAM_LIMITATION(400, 10005, "Have something exam limitation is unknown."),
    HAVE_REPEAT_TIME_AND_ITEM(10006, "Have Repeat Time Repeat Item."),
    DEVICE_IS_BOUND(10007, "Sorry that the device has been bound"),
    EXIST_DEVICE_ID(10008, "This device ID already exists"),
    UNFINISHEED_MEDICAL_CONSULTATION(10009, "Unfinished medical consultation"),
    HEALTH_GROUP_HEADER_REPEAT(10010, "health group header erpeat"),
    HAS_VALIDITY_SERVICE_PACKAGE(10011, "The validity of the existing service pack"),
    NO_BUY_SERVICE_PACKAGE(10012, "No buy service pack"),
    HAS_NOT_FORCE_SERVICE_PACKAGE_TO_BUY_CUSTOM_SERVICE(10013, "Has not force service package and not buy custom service"),
    HAS_NOT_FORCE_SERVICE_PACKAGE_TO_BUY_SERVICE_PACKAGE(10014, "Has not force service package and not buy service package"),
    NEED_ME_OR_ASSISTANT_TO_CHANGE(10015, "Need me or assistant to change"),
    ERROR_SERVICE_COUNT(10016, "error service count"),
    REPEAT_PHONE_NUMBER(10017, "Repeat phone number"),
    NUMBER_OF_MEDICAL_CONSULTATIONS_HAS_BEEN_EXHAUSTED(10018, "Number of medical consultations has been exhausted"),
    NUMBER_OF_HEALTH_CONSULTATIONS_HAS_BEEN_EXHAUSTED(10019, "Number of health consultations has been exhausted"),
    DUPLICATE_SERVICE_DETAIL(10020, "The package has duplicate Service detail"),
    NOT_BE_LESS_THAN_THE_EFFECTIVE_DATE_OF_THE_MONTH(10021, "Not be less than the effective date of the month"),
    YOU_DO_NOT_HAVE_PERMISSION(10022, "You don't have permission"),
    SERVICE_PRICE_CAN_NOT(10023, "Service price can not be less than the total value of the extension"),
    EVENTS_WITHIN_7_DAYS_FROM_THE_DAY_CAN_NOT_BE_MODIFIED(10024, "Events within 7 days from the day can not be modified"),
    MODIFICATION_DATE_CAN_NOT_BE_LESS_THAN_7_DAYS_FROM_THE_DAY(10025, "Modification date can not be less than 7 days from the day"),
    MODIFICATION_DATE_CAN_NOT_BE_LESS_THAN_THE_PLAN_END_DATE(10026, "Modification date can not be less than the plan end date"),
    SERVICE_START_TIME_ERROR(10027, "Service start time error"),
    SERVICE_TIME_ERROR(10028, "Service time error"),
    EXIST_STROKE_FOLLOW_UP(10029, "exist stroke follow up"),
    INSUFFICIENT_AUTHORITY(10030,"Insufficient authority"),
    ABNORMAL_TIME(400, 10040, "abnormal time is error."),
	DOWNLOAD_LOG_FAIL_1(10031, "download log fail, The log document is not exist"),
	DOWNLOAD_LOG_FAIL_2(10032, "download log fail, io exception"),
	OPEN_LOG_FAIL(10033, "open log file error"),
	UNCOMPRESS_LOG_FAIL(10034, "uncompress log file error"),
	FILE_NOT_EXIST(10035, "file is not exist"),
	IO_EXCEPTION(10036, "io exception"),
	FILE_UPLOAD_ERROR(10037, "upload file error"),
	PARSE_EXCEL_ERROR(10038, "parse excel error"),
	UPLOAD_IMG_FORMAT_ERROR(10039, "upload image format error"),
	UPLOAD_XLS_FORMAT_ERROR(10040, "upload xls file format error"),
	THREAD_EXCEPTION(10041, "multi thread error");
	
	

    private int httpStatusCode;
    private int errorCode;
    private String message;

    private static final int DEFAULT_STATUS_CODE = 400;

    private ErrorCode(int httpStatusCode, int errorCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    private ErrorCode(int errorCode, String message) {
        this.httpStatusCode = DEFAULT_STATUS_CODE;
        this.errorCode = errorCode;
        this.message = message;
    }

    private ErrorCode(int errorCode) {
        this.httpStatusCode = DEFAULT_STATUS_CODE;
        this.errorCode = errorCode;
        this.message = "";
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * <pre>
     * Return json format:
     *    {
     * 		"errorCode": 1234,
     * 		"message": "error message"
     *    }
     * </pre>
     */
    public String toJson() {
        String msg = ErrorMessagePropertiesUtil.getInstance().getString(
                String.valueOf(errorCode), message);
        return new StringBuilder("{\"errorCode\":")//
                .append(errorCode)//
                .append(",\"message\":\"")//
                .append(msg)//
                .append("\" }")//
                .toString();
    }

    public String getCnMessage() {
        String msg = ErrorMessagePropertiesUtil.getInstance().getString(
                String.valueOf(errorCode));
        return msg;
    }
}
