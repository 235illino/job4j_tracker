package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String query = "insert into items(name) values (?)";
        try (PreparedStatement statement = cn.prepareStatement(query,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            try (ResultSet generatedKey = statement.getGeneratedKeys()) {
                if (generatedKey.next()) {
                    item.setId(generatedKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        String query = "update items set name = ? where id = ? ";
        try (PreparedStatement statement = cn.prepareStatement(query)) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "delete from items where id = ? ";
        try (PreparedStatement statement = cn.prepareStatement(query)) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String query = "select * from items";
        try (PreparedStatement statement = cn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        String query = "select * from items where name = ?";
        try (PreparedStatement statement = cn.prepareStatement(query)) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                    items.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        String query = "select * from items where id = ?";
        try (PreparedStatement statement = cn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    item = new Item(resultSet.getString("name"));
                    item.setId(resultSet.getInt("id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }




}