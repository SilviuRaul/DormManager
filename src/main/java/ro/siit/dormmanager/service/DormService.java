package ro.siit.dormmanager.service;

import ro.siit.dormmanager.model.Dorm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DormService {

    private static DormService instance;

    private Connection connection;

    private DormService() {
    }

    @Override
    protected void finalize() throws Throwable {
        getConnection().close();
    }

    public static DormService getInstance() {
        if (instance == null) {
            instance = new DormService();
        }
        return instance;
    }

    private Connection getConnection() {
        if (connection == null) {
            String connectionString = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres";
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
                Class.forName("org.postgresql.Driver").newInstance();
                connection = DriverManager.getConnection(connectionString);
            } catch (final InstantiationException e) {
                e.printStackTrace();
            } catch (final IllegalAccessException e) {
                e.printStackTrace();
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public List<Dorm> getDorms() {
        List<Dorm> outcome  = new ArrayList<>();

        ResultSet rs = null;

        try {
            Statement statement = getConnection().createStatement();
            rs = statement.executeQuery("SELECT * FROM dorm");
            while (rs.next()) {
                Dorm dorm = new Dorm();
                dorm.setDormId( rs.getInt("dormId") );
                dorm.setName( rs.getString("name") );
                dorm.setRoomSize( rs.getInt("roomSize") );
                dorm.setDormType( rs.getString("dormType") );
                dorm.setNumberOfRooms( rs.getInt("numberOfRooms") );

                outcome.add( dorm );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outcome;
    }

    public void addDorm(Dorm dorm){
        try {
            PreparedStatement statement = getConnection().prepareStatement(
                    "INSERT INTO dorm (name, \"roomSize\", \"dormType\", \"numberOfRooms\") VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, dorm.getName());
            statement.setInt(2, dorm.getRoomSize());
            statement.setString(3, dorm.getDormType());
            statement.setInt(4, dorm.getNumberOfRooms());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDorm(Dorm dorm){
        try {
            PreparedStatement statement = getConnection().prepareStatement(
                    "UPDATE dorm SET name = ?, \"roomSize\" = ?, \"dormType\" = ?, \"numberOfRooms\" = ? WHERE \"dormId\" = ?"
            );
            statement.setString(1, dorm.getName());
            statement.setInt(2, dorm.getRoomSize());
            statement.setString(3, dorm.getDormType());
            statement.setInt(4, dorm.getNumberOfRooms());
            statement.setInt(5, dorm.getDormId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dorm getDorm(Integer dormId) {

        ResultSet rs = null;

        try {
            PreparedStatement statement  = getConnection().prepareStatement("SELECT * FROM dorm WHERE \"dormId\" = ?");
            statement.setInt(1, dormId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Dorm dorm = new Dorm();
                dorm.setDormId( rs.getInt("dormId") );
                dorm.setName( rs.getString("name") );
                dorm.setRoomSize( rs.getInt("roomSize") );
                dorm.setDormType( rs.getString("dormType") );
                dorm.setNumberOfRooms( rs.getInt("numberOfRooms") );

                return dorm;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteDorm(Integer dormId) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM dorm WHERE \"dormId\" = ?");
            statement.setInt(1, dormId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
