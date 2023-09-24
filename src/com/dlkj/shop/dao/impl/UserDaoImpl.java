package com.dlkj.shop.dao.impl;
import com.dlkj.shop.dao.UserDao;
import com.dlkj.shop.pojo.User;
import java.sql.SQLException;
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public int modifyUserPw(User user) {
        String sql = "update smbms_user set userPassword=? where id=?";
        Object[] params = {user.getUserPassword(),user.getId()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public User findOneUser(String uc, String pw) {
        String sql = "select * from smbms_user where userCode=? and userPassword=?";
        Object[] params = {uc,pw};
        res = super.executeQuery(sql,params);
        User user = null;
        try {
            if (res.next()){
                user = new User();
                user.setId(res.getInt("id"));
                user.setUserCode(res.getString("userCode"));
                user.setUserName(res.getString("userName"));
                user.setUserPassword(res.getString("UserPassword"));
                user.setGender(res.getInt("Gender"));
                user.setBirthday(res.getString("Birthday"));
                user.setPhone(res.getString("Phone"));
                user.setAddress(res.getString("Address"));
                user.setUserRole(res.getInt("UserRole"));
                user.setCreatedBy(res.getInt("CreatedBy"));
                user.setCreationDate(res.getString("CreationDate"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            super.closeAll();
        }
    }
}
