<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table border="1" align="center">
    	<thead>
    		<tr>
    			<th>序号</th>
    			<th>员工编号</th>
    			<th>员工姓名</th>
    			<th>薪水</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
    	<s:if test="#request.empList!=null">
    		<s:iterator var="emp" value="#request.empList" status="st">
    			<tr>
					<td><s:property value="#st.count" /></td>  
					<td><s:property value="#emp.id" /></td>  
					<td><s:property value="#emp.empName" /></td>  
					<td><s:property value="#emp.salary" /></td>  
					<td>更新 删除</td>    	  			
    			</tr>
    		</s:iterator>
    	</s:if>
    	<s:else>
    		<tr>
    			<td colspan="5">没有数据....</td>
    		</tr>
    	</s:else>
    	</tbody>
    </table>
  </body>
</html>
