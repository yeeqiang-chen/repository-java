package com.yiqiang.repository.javase.thread.executorpool.chapter04;

import java.util.concurrent.Callable;

/**
 * Title:
 * Description:
 * This class encapsulate a user validation system to be executed as a Callable object.
 * If the user is validated, it returns the name of the validation system. If not,
 * it throws an Exception
 * Create Time: 2017/1/20 0020 1:47
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class TaskValidator implements Callable<String> {

    /**
     * The user validator used to validate the user.
     */
    private UserValidator validator;
    /**
     * The name of the user
     */
    private String user;
    /**
     * The password of the user
     */
    private String password;

    /**
     * Constructor of the class
     * @param validator The user validator system used to validate it
     * @param user The name of the user
     * @param password The password of the user
     */
    public TaskValidator(UserValidator validator, String user, String password){
        this.validator=validator;
        this.user=user;
        this.password=password;
    }

    /**
     * Core method of the Callable interface. Tries to validate the user using the user
     * validation system. If the user is validated, returns the name of the validation system.
     * If not, throws and Exception
     * @return The name of the user validation system.
     * @throws Exception An exception when the user is not validated
     */
    @Override
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("%s: The user has not been found\n",validator.getName());
            throw new Exception("Error validating user");
        }
        System.out.printf("%s: The user has been found\n",validator.getName());
        return validator.getName();
    }

}
