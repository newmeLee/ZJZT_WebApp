package com.zjzt.webService;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "ZJZT_HealthNews", // ����ʵ���������
serviceName = "ZJZT_HealthNewsService", // Ĭ���ڷ����ķ���ʵ���ߵ����ƺ�������Service
portName = "ZJZT_HealthNewsServicePort", // �������͵�����: Ĭ���� �����ķ���ʵ����(MyWebService)
targetNamespace = "webService.zjzt.com" // ����ws����������ռ�,�˿ռ�Ĭ��Ϊ��ǰ�����·���� "��д"������Ҳ��
)
public interface HealthInfoService {

	/**
	 * ��ȡ���еĽ�����Ѷ��Ϣ
	 * 
	 * @param userId
	 *            �û���
	 * @param password
	 *            ����
	 * @return Json�ַ�����ʽ����Ѷ��Ϣ
	 */
	@WebResult(name = "HealthNews")
	String getAllHealthNews(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * �������ŷ���Id��ȡ���������Ѷ
	 * 
	 * @param userId
	 *            �û���
	 * @param password
	 *            ����
	 * @param classId
	 *            ���ŷ���Id
	 * @return Json�ַ�����ʽ��������Ϣ
	 */
	@WebResult(name = "HealthNews")
	String getHealthNewsById(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "classId") int classId);

	/**
	 * 
	 * @param userId
	 *            �û���
	 * @param password
	 *            �û��˺�
	 * @return
	 */
	@WebResult(name = "HealthNewsClass")
	String getHealthNewsClass(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * ��ȡ�û�ѡ��ҳ����б���Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	@WebResult(name = "UserOption")
	String getUserOptions(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password);

	/**
	 * �����ֻ������ѯ�û�������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name = "UserInfo")
	String getUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * �ж��û��Ƿ����
	 * 
	 * @param phone
	 * @return
	 */
	@WebResult(name = "existFlag")
	String existUser(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * �����ֻ��Ż�ȡ�û�����������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name = "UserHealthInfo")
	String getUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);

	/**
	 * �޸��û�����������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param columnName
	 * @param value
	 * @param phone
	 * @return
	 */
	@WebResult(name = "updateFlag")
	String updateUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "columnName") String columnName,
			@WebParam(name = "value") Object value,
			@WebParam(name = "phone") String phone);

	/**
	 * �޸��û�������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param columnName
	 * @param value
	 * @param phone
	 * @return
	 */
	@WebResult(name = "updateFlag")
	String updateUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "columnName") String columnName,
			@WebParam(name = "value") Object value,
			@WebParam(name = "phone") String phone);

	/**
	 * �����û������ͺ�������������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @param name
	 * @return
	 */
	@WebResult(name = "saveFlag")
	String saveUserBaseInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "name") String name);

	/**
	 * �����û������ͺ��������û�������Ϣ
	 * 
	 * @param userId
	 * @param password
	 * @param phone
	 * @param name
	 * @return
	 */
	@WebResult(name = "saveFlag")
	String saveUserHealthInfo(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "name") String name);

	/**
	 * �޸��û�����
	 * 
	 * @param phone
	 * @param newPassword
	 * @return
	 */
	@WebResult(name = "updateUserPassword")
	String updateUserPassword(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone,
			@WebParam(name = "newPassword") String newPassword);
	/**
	 * ��ȡ�û�������
	 * @param userId
	 * @param password
	 * @param phone
	 * @return
	 */
	@WebResult(name="getUserPassword")
	String getUserPassword(@WebParam(name = "userId") String userId,
			@WebParam(name = "password") String password,
			@WebParam(name = "phone") String phone);
}