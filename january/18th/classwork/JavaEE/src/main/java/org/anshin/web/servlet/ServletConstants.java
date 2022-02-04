package org.anshin.web.servlet;

public final class ServletConstants {
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";


    public static final String PARAMETER_EMAIL = "email";
    public static final String PARAMETER_LOGIN = "login";
    public static final String PARAMETER_PASSWORD = "password";
    public static final String PARAMETER_KEYWORD = "keyword";
    public static final String PARAMETER_CALCULATOR_FIRST_VALUE = "firstValue";
    public static final String PARAMETER_CALCULATOR_SECOND_VALUE = "secondValue";
    public static final String PARAMETER_CALCULATOR_OPERATION_TYPE = "operationType";


    public static final String ATTRIBUTE_SESSION_AUTH_USER = "authUser";
    public static final String ATTRIBUTE_REGISTRATION_RESULT = "registrationResult";
    public static final String ATTRIBUTE_WRONG_VALUE_MESSAGE = "wrongValueMessage";
    public static final String ATTRIBUTE_AUTHENTICATION_FAILED_MESSAGE = "failedAuthenticationMessage";
    public static final String ATTRIBUTE_USER_SERVICE = "userService";
    public static final String ATTRIBUTE_CALCULATOR_SERVICE = "calculatorService";
    public static final String ATTRIBUTE_CALCULATION_RESULT_SERVICE = "resultService";
    public static final String ATTRIBUTE_OPERATION_TYPES = "operationTypes";
    public static final String ATTRIBUTE_WRONG_PARAMETER_MESSAGE = "wrongParameterMessage";
    public static final String ATTRIBUTE_CALCULATION_RESULT = "result";
    public static final String ATTRIBUTE_CALCULATION_HISTORY = "calculationHistory";
    public static final String ATTRIBUTE_USERS = "users";
    public static final String ATTRIBUTE_USER_IS_VERIFY = "isUserVerify";
    public static final String ATTRIBUTE_EMAIL = "email";



    public static final String URL_REGISTRATION_SERVLET = "/registration";
    public static final String URL_LOGOUT_SERVLET = "/logout";
    public static final String URL_CALCULATOR_SERVLET = "/calculator";
    public static final String URL_CALCULATION_HISTORY_SERVLET = "/history";
    public static final String URL_AUTHENTICATION_SERVLET = "/auth";
    public static final String URL_ALL_USERS_SERVLET = "/users";
    public static final String URL_HOME_SERVLET = "/";
    public static final String URL_USER_SETTINGS_SERVLET = "/user-settings";
    public static final String URL_PASSWORD_RESET_SERVLET = "/password-reset";
    public static final String URL_NEW_KEYWORD_SERVLET = "/user-settings/new-keyword";


    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";
    public static final String NAME_LOGOUT_SERVLET = "LogoutServlet";
    public static final String NAME_CALCULATOR_SERVLET = "CalculatorServlet";
    public static final String NAME_CALCULATION_HISTORY_SERVLET = "CalculationHistoryServlet";
    public static final String NAME_AUTHENTICATION_SERVLET = "AuthenticationServlet";
    public static final String NAME_ALL_USERS_SERVLET = "AllUsersServlet";
    public static final String NAME_HOME_SERVLET = "HomeServlet";
    public static final String NAME_USER_SETTINGS = "UserSettingsServlet";
    public static final String NAME_PASSWORD_RESET_SERVLET = "PasswordResetServlet";
    public static final String NAME_NEW_KEYWORD_SERVLET = "NewKeywordServlet";


    public static final String PATH_HOME_JSP = "/pages/home/home.jsp";
    public static final String PATH_REGISTRATION_JSP = "/pages/user/registration.jsp";
    public static final String PATH_AUTHENTICATION_JSP = "/pages/user/authentication.jsp";
    public static final String PATH_CALCULATOR_JSP = "/pages/calculator/calculator.jsp";
    public static final String PATH_CALCULATION_HISTORY_JSP = "/pages/calculator/calculation-history.jsp";
    public static final String PATH_USERS_JSP = "/pages/admin/users.jsp";
    public static final String PATH_USER_SETTINGS_JSP = "/pages/user/user-settings.jsp";
    public static final String PATH_PASSWORD_RESET_JSP = "/pages/user/password-reset.jsp";


    public static final String SUCCESSFUL_MESSAGE_REGISTRATION = "You are registered!";
    public static final String SUCCESSFUL_MESSAGE_LOGOUT = "You logged out!";


    public static final String FAILED_MESSAGE_REGISTRATION = "Registration failed!";
    public static final String FAILED_MESSAGE_USER_EXISTS= "User with this username or email already exists!";
    public static final String FAILED_MESSAGE_AUTHENTICATION = "There is no user with this username and password!";
    public static final String FAILED_MESSAGE_PASSWORD_RESET = "There is no user with this email or keyword!";

    private ServletConstants() {
    }
}
