package jp.co.aforce.tool;

public class ConstNum {

	public static final String SQL_M_INSERT = "INSERT INTO member_info_maekawa VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SQL_M_CHECK = "SELECT COUNT(*) FROM member_info_maekawa "
											+ "WHERE last_name =?"
											+ "AND first_name =?"
											+ "AND sex =?"
											+ "AND birth_year =?"
											+ "AND birth_month =?"
											+ "AND birth_day =?"
											+ "AND post_code =?"
											+ "AND prefectures =?"
											+ "AND municipalities =?"
											+ "AND phone_number =?"
											+ "AND mail_address =?"
											+ "AND password =?";
	public static final String SQL_M_SEARCH = "SELECT * FROM member_info_maekawa WHERE member_id =? AND password =?";
	public static final String SQL_M_DELETE = "DELETE FROM member_info_maekawa WHERE member_id =?";
	public static final String SQL_M_UPDATE = "UPDATE member_info_maekawa SET "
											+ "last_name =?, "
											+ "first_name =?, "
											+ "sex =?, "
											+ "birth_year =?, "
											+ "birth_month =?, "
											+ "birth_day =?, "
											+ "post_code =?, "
											+ "prefectures =?, "
											+ "municipalities =?, "
											+ "building =?, "
											+ "phone_number =?, "
											+ "mail_address =? "
											+ "WHERE member_id =?";

	public static final String SQL_P_INSERT = "INSERT INTO product_info_maekawa VALUES(NULL, ?,?,?,?,?,?)";
	public static final String SQL_P_SEARCH = "SELECT * FROM product_info_maekawa WHERE product_id =?";
	public static final String SQL_P_SEARCHALL = "SELECT * FROM product_info_maekawa ORDER BY product_id DESC";
	public static final String SQL_P_DELETE = "DELETE FROM product_info_maekawa WHERE product_id =?";
	public static final String SQL_P_UPDATE = "UPDATE product_info_maekawa SET amount =? WHERE product_id =?";
	public static final String SQL_P_CHECK = "SELECT COUNT(*) FROM product_info_maekawa WHERE product_name =? AND price =?";
	public static final String SQL_P_KEY = "SELECT * FROM product_info_maekawa WHERE product_name LIKE ? ORDER BY product_id DESC";
	public static final String SQL_P_EXPENSIVE = "SELECT * FROM product_info_maekawa ORDER BY price DESC";
	public static final String SQL_P_REASNABLE = "SELECT * FROM product_info_maekawa ORDER BY price ASC";
	public static final String SQL_P_CHANGE = "UPDATE product_info_maekawa SET product_name =?, price =?, amount =?, contentType =?, base64String =?, info =? WHERE product_id =?";
	public static final String SQL_P_FAVORITE = "SELECT * FROM favorite_product_maekawa";

	public static final String SQL_A_SEARCH = "SELECT * FROM admin_info_maekawa WHERE admin_id =? AND password =?";

	public static final String SQL_D_INSERT = "INSERT INTO purchase_log_maekawa VALUES(NULL, ?,?,?,?,?)";
	public static final String SQL_D_SEARCH = "SELECT * FROM purchase_log_maekawa";
	public static final String SQL_D_CHANGE = "UPDATE product_info_maekawa SET amount = amount-? WHERE product_id =?";

	public static final String SQL_F_INSERT = "INSERT INTO favorite_product_maekawa VALUES(NULL,?,?,?,?,?,?)";
	public static final String SQL_F_CHECK = "SELECT * FROM favorite_product_maekawa WHERE product_id =? AND member_id =?";
	public static final String SQL_F_SEARCH = "SELECT * FROM favorite_product_maekawa WHERE member_id =?";
	public static final String SQL_F_DELETE = "DELETE FROM favorite_product_maekawa WHERE product_id =? AND member_id =?";

	public static final String W_MSG = "は必須入力項目です。";
}
