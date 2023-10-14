package org.example.service;

import org.example.controller.Controller;
import org.example.util.ConnectionUtil;

import java.sql.*;

public class AppService {
    public void start() throws SQLException {
        Controller.home();
    }

}
