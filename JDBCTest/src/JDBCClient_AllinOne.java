/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCClient_AllinOne {
    public static void main(String[] args) throws Exception {

        //1. DB 연결
        Class.forName("com.mysql.cj.jdbc.Driver"); //메모리로 올리는 역할

        //정보 입력
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_test?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        String user = "root";
        String pwd = "12345678";

        //정보 가지고 Connection 객체 생성
        Connection con = DriverManager.getConnection(url, user, pwd); //연결 시도, 성공 시 Connection 객체 리턴
        System.out.println(con);


        //2. DB에 insert
        int ret = -1;
        String sql = "insert into jdbc_table (col_nm, col_not_null, col_default_val) value (?, ?, ?)";

        //3. 쿼리 작성
        //PreparedStatement : SELECT,INSERT,UPDATE 등등을 처리하는 애
        PreparedStatement pstmt = con.prepareStatement(sql); //Connection 객체 이용, 수행하고자 하는 쿼리 전달하면 댐
        pstmt.setString(1, "hello"); //물음표 하나 하나에 해당
        pstmt.setString(2, "world");
        pstmt.setString(3, "jdbc");
        //모든 준비 끝!

        //4. insert문 수행
        ret = pstmt.executeUpdate(); //executeUpdate()는 insert, update, delete 때 다 씀. (단, select는 받아와야 하므로 executeQuery()?를 씀)
        System.out.println(ret); //ret은 영향받은 row 개수 (1건이 업데이트 됐으므로 1을 리턴)
    }
}
 */