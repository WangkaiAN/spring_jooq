/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos;


import java.time.LocalDateTime;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.generated.tables.User;
import org.jooq.generated.tables.records.UserRecord;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserDao extends DAOImpl<UserRecord, org.jooq.generated.tables.pojos.User, String> {

    /**
     * Create a new UserDao without any configuration
     */
    public UserDao() {
        super(User.USER, org.jooq.generated.tables.pojos.User.class);
    }

    /**
     * Create a new UserDao with an attached configuration
     */
    public UserDao(Configuration configuration) {
        super(User.USER, org.jooq.generated.tables.pojos.User.class, configuration);
    }

    @Override
    public String getId(org.jooq.generated.tables.pojos.User object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchRangeOfId(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchById(String... values) {
        return fetch(User.USER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.jooq.generated.tables.pojos.User fetchOneById(String value) {
        return fetchOne(User.USER.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(User.USER.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchByName(String... values) {
        return fetch(User.USER.NAME, values);
    }

    /**
     * Fetch records that have <code>age BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchRangeOfAge(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(User.USER.AGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchByAge(Integer... values) {
        return fetch(User.USER.AGE, values);
    }

    /**
     * Fetch records that have <code>create_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchRangeOfCreateTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(User.USER.CREATE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>create_time IN (values)</code>
     */
    public List<org.jooq.generated.tables.pojos.User> fetchByCreateTime(LocalDateTime... values) {
        return fetch(User.USER.CREATE_TIME, values);
    }
}