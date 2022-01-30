package TeamDebugger;

import javax.swing.*;
import java.sql.*;


public class ConnectionProvider {

    private Connection con;
    private Statement st;
    ResultSet rs;
    int flag = 0;

    public ConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorlist", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void RegisterDoc(String queryInsert) {


        try {
            st.executeUpdate(queryInsert);
            System.out.println(queryInsert);

            JOptionPane.showMessageDialog(null, "Information Updated Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update not Completed!!");
        }
    }

    public void RegisterUser(String queryInsert) {

        try {
            st.executeUpdate(queryInsert);
            System.out.println(queryInsert);

            JOptionPane.showMessageDialog(null, "Information Updated Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update not Completed!!");
        }


    }

    public void LoginDoc(String queryLogin, String userName, String pass) {
        try {
            rs = st.executeQuery(queryLogin);
            while (rs.next()) {

                String userIdentity = rs.getString(2);
                String userPass = rs.getString(4);

                if (userName.equals(userIdentity) && pass.equals(userPass)) {
                    JOptionPane.showMessageDialog(null, "**Most Welcome**");
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "you are not a valid user");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void LoginCus(String queryLogin, String userName, String pass) {
        try {
            rs = st.executeQuery(queryLogin);
            while (rs.next()) {

                String userIdentity = rs.getString(2);
                String userPass = rs.getString(4);

                if (userName.equals(userIdentity) && pass.equals(userPass)) {
                    JOptionPane.showMessageDialog(null, "**Most Welcome**");
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "you are not a valid user");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}