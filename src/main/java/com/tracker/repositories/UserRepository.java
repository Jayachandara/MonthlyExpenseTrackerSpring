package com.tracker.repositories;

import com.tracker.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Controller, Service, Repository, Component

//On run time spring will scan all the classes in the base package
// and if any stereotype annotation it identifies
//then it will consider as bean(spring level object)
//and creat beans and store it in spring IOC container
//JPA with hibernate
//It is the communication medium between database and our java application
@Repository
public class UserRepository {

    //JPA-> Java persistence API
    // it will provide specification for any ORM tool
    //Specification JPA -> we are tightly coupled with JPA not hibernate ORM
    // Implementation -> Hibernate
    //JPA with hibernate and other ORM frameworks


    @PersistenceContext
    private EntityManager entityManager; //establish connection between database

    public User getUserById(Integer userId){

        //first it will prepare a select query
        //select * from user where userID = 1;
        //database hit
        // hibernate fetched this data from users table
        //user_id: 1,name: Jay,password_hash: 143,email: jay@gmail.com,created_at 06/06/2025 -> tabular format
        // once data fetched from database it will map that relational data into our entity object(User)
        // hibernate will create a User object and map database data to User object
        //find method can only fetch the record based on primary
        User user = entityManager.find(User.class, userId);

        return user;
    }

    //Jay --> user record in database
    public User getUserByName(String userName){//Jay
        //if we want to fetch record based on name
        //HQL -> hibernate internally converts this into native query (MySQL)
        // select * from users where user_name = 'Jay';
        User user = entityManager.createQuery("select u from User u where u.userName = :userName",User.class)
                .setParameter("userName", userName).getSingleResult();

        return user;
    }

    @Transactional
    public void createUser(User user){
         entityManager.persist(user);
    }

}
