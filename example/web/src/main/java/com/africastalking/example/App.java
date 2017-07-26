package com.africastalking.example;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

/**
 * Created by jay on 7/26/17.
 */

public class App {

    private static final int HTTP_PORT = 3000;
    private static final int RPC_PORT = 3001;
    private static final String USERNAME = "sandbox";
    private static final String API_KEY = "3cb2185af3e13541cfc38047b463a39e2a255b9ca9e781e9d923ec668a21a07f";
    private static final String SIP_USERNAME = "+254792424735";
    private static final String SIP_PASSWORD = "DOPx_7bb9eab00b";
    private static final String SIP_HOST = "sandbox.sip.africastalking.com";


    private static HandlebarsTemplateEngine hbs = new HandlebarsTemplateEngine("/views");
//    ATServer server;

    public static void main(String[] args) {
        // configure spark
        port(3000);
        staticFiles.location("/public");
        staticFiles.expireTime(300L);
//        enableDebugScreen();

        // set up routes
        get("/", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "index.hbs"));
        });
        get("/sms", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "sms.hbs"));
        });
        get("/account", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "account.hbs"));
        });
        get("/airtime", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "airtime.hbs"));
        });
        get("/payment", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "payment.hbs"));
        });
        get("/voice", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            return hbs.render(new ModelAndView(data, "voice.hbs"));
        });
    }


//    private void setupAfricastalking() throws IOException {
//        server = AfricasTalking.initialize(USERNAME, API_KEY, "sandbox");
//        server.startInsecure(3000);
//        server.addSipCredentials(SIP_USERNAME, SIP_PASSWORD, SIP_HOST);
//    }

}
