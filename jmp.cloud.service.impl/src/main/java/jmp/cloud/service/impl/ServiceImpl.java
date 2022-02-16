package jmp.cloud.service.impl;

import Connect.Connect;
import jmp.dto.BankCard;
import jmp.dto.BankCardType;
import jmp.dto.Subscription;
import jmp.dto.User;
import jmp.service.api.IService;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Contains the implementation of the interface IService.
 * @author Esteban_Lopez1
 */
public class ServiceImpl implements IService {
    private static final Connect con = new Connect();
    private static final Connection connection = con.getConnect();

    public static final String INSERT = "INSERT INTO userdata (name, surname, birthday," +
            " cardtype, cardnumber, subscriptionstatus, subscriptiondate)" + "VALUES (?,?,?,?,?,?,?)";

    public static final String READ = "SELECT * FROM userdata";

    public static final String READ_CARDNUMBER = "SELECT * FROM userdata WHERE cardnumber LIKE";

    /**
     *  Adds the userinfo to the database.
     * @param bankCard We get the info that is going to be added to the database
     * @param t We get the type of card, also to be saved in the database
     */
    @Override
    public void subscribe(BankCard bankCard, BankCardType t) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, bankCard.getUser().getName());
            preparedStatement.setString(2, bankCard.getUser().getSurName());
            preparedStatement.setString(3, bankCard.getUser().getBirthDay().toString());
            preparedStatement.setString(4, t.toString());
            preparedStatement.setString(5, bankCard.getNumber());
            preparedStatement.setString(6, "ACTIVE");
            preparedStatement.setString(7, LocalDate.now().toString());
            preparedStatement.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("User already registered");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Writing error");
        }
    }

    /**
     * Returns the subscription that has the same number, or the subscriptions with the same
     * starting numbers if you only write some of them.
     * @param input String to be searched has to be integer value
     * @return Return an optional in case subscription is not found
     */
    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String input) {
        ResultSet rs;
        try{
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(READ_CARDNUMBER + "'"+input+"%';");

            if(rs.next()){
                var sub = new Subscription(rs.getString("cardnumber"),
                        LocalDate.parse(rs.getString("subscriptiondate")));

                return Optional.of(sub);

            }else{
                return Optional.empty();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fetching sub error");
            return Optional.empty();
        }
    }

    /**
     * Consults the database and gets all the user information in it;
     * @return Returns a List of User objects
     */
    @Override
    public List<User> getAllUsers() {
        var list = new ArrayList<User>();
        ResultSet rs;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(READ);
            //Reads each row and turns it into User object, then adds it to the Arraylist.
            while (rs.next()) {
                User user = convertUser(rs);
                list.add(user);
            }
            return Collections.unmodifiableList(list);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Consult all the subscriptions written in the database
     * @param input Predicate, in this case we check if the subscription isn't null.
     * @return return the List of Subscription objects that have been found
     */
    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> input) {
        var SubList = new ArrayList<Subscription>();
        ResultSet rs;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(READ);
            //Reads each row and turns it into User object, then adds it to the Arraylist.
            while (rs.next()) {
                var subscription = convertSubscription(rs);
                SubList.add(subscription);
            }
            return Collections.unmodifiableList(SubList);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts the selected mysql fields to Subscription object
     * @param rs result set from the MySQL reading
     * @return Returns a Subscription object.
     * @throws SQLException
     */
    private Subscription convertSubscription(ResultSet rs) throws SQLException {
        return new Subscription(rs.getString("cardnumber"), LocalDate.parse(
                rs.getString("subscriptiondate")));
    }

    /**
     * Converts the selected mysql fields to user object
     * @param rs result set from the MySQL reading
     * @return  returns a user
     * @throws SQLException
     */
    private User convertUser(ResultSet rs) throws SQLException {
        return new User(rs.getString("name"),
                rs.getString("surname"),
                LocalDate.parse(rs.getString("birthday")));
    }
}
