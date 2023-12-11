package com.spring.ex.command;

import com.spring.ex.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdDupCheckCommand {

    @Autowired
    private UserDAO dao;

    public int execute(String id) {
        System.out.println("========== IdDupCheckCommand Running ==========");
        System.out.println("ID : " + id);

        int result = dao.idDupCheck(id);

        if (result >= 1) {
            System.out.println("========== ID Duplicate ==========");

        } else {
            System.out.println("========== ID Not Duplicate ==========");

        }

        return result;
    }
}
