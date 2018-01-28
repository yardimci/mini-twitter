package challenge.constant;

public class SqlQuery {
    private SqlQuery() {

    }
    public static final String GET_USER_BY_USERNAME = "select * from users where username=?";
    public static final String GET_USER_BY_ID = "select * from users where id=?";
    public static final String GET_MESSAGES_BY_USER = "SELECT U.USERNAME, M.CONTENT FROM USERS U " +
            "LEFT JOIN  MESSAGES M ON U.ID=M.PERSON_ID " +
            "WHERE M.PERSON_ID IN (SELECT ID FROM USERS WHERE ID IN (SELECT PERSON_ID FROM FOLLOWERS F " +
            "WHERE F.FOLLOWER_PERSON_ID = ?));";
    public static final  String GET_FOLLOWERS_BY_USER = "SELECT * FROM USERS " +
            "WHERE ID IN (SELECT F.FOLLOWER_PERSON_ID AS FOLLOWERS FROM USERS U " +
            "LEFT JOIN FOLLOWERS F ON U.ID = F.PERSON_ID " +
            "WHERE U.ID = ?);";
    public static final String GET_FOLLOWING_LIST_BY_USER = "SELECT * FROM USERS " +
            "WHERE ID IN (SELECT PERSON_ID FROM FOLLOWERS F " +
            "WHERE F.FOLLOWER_PERSON_ID = ?);";
    public static final String UNFOLLOW_USER = "DELETE FROM FOLLOWERS WHERE PERSON_ID = ? AND FOLLOWER_PERSON_ID=?;";
    public static final String FOLLOW_USER = "INSERT INTO FOLLOWERS (PERSON_ID, FOLLOWER_PERSON_ID) VALUES (?,?);";
    public static final String MOST_POPULER_PAIR_LIST =
            "SELECT * FROM USERS INNER JOIN " +
            "(SELECT T1.PERSON_ID, T1.FOLLOWER_PERSON_ID, " +
            "T1.NUM_FOLLOWERS FROM (SELECT F.PERSON_ID, F.FOLLOWER_PERSON_ID, NUM_FOLLOWERS FROM " +
            "FOLLOWERS F INNER JOIN (SELECT PERSON_ID, COUNT(*) AS NUM_FOLLOWERS FROM   FOLLOWERS " +
            "GROUP  BY PERSON_ID) AS T ON F.FOLLOWER_PERSON_ID = T.PERSON_ID) T1 " +
            "INNER JOIN (SELECT PERSON_ID, MAX(NUM_FOLLOWERS) AS NUM_FOLLOWERS FROM " +
            "(SELECT F.PERSON_ID, F.FOLLOWER_PERSON_ID, NUM_FOLLOWERS FROM   FOLLOWERS F " +
            "INNER JOIN (SELECT PERSON_ID, COUNT(*) AS NUM_FOLLOWERS FROM FOLLOWERS " +
            "GROUP  BY PERSON_ID) AS T ON F.FOLLOWER_PERSON_ID = T.PERSON_ID) " +
            "GROUP  BY PERSON_ID) T2 ON T1.PERSON_ID = T2.PERSON_ID AND T1.NUM_FOLLOWERS = T2.NUM_FOLLOWERS) T3 " +
            "ON ID = T3.PERSON_ID; ";



}
