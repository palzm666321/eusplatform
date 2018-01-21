<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String SCHEDULE_AUDIT_URL = "pages/back/admin/schedule/ScheduleActionFront!editByAnote.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/audit/audit_schedule_apply.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="41"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-check"></span>&nbsp;任务协调审核</strong>
				</div>
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>申请标题：</strong></td>
								<td>${schedule.title}</td>
							</tr>
							<tr>
								<td><strong>任务类型：</strong></td>
								<td>${itemMap[schedule.iid]}</td>
							</tr>
							<tr>
								<td><strong>总人数：</strong></td>
								<td>${schedule.ecount}人</td>
							</tr>
							<tr>
								<td><strong>申请日期：</strong></td>
								<td>${schedule.sdate}</td>
							</tr>
							<tr>
								<td><strong>任务日期：</strong></td>
								<td>${schedule.subdate}</td>
							</tr>
							<tr>
								<td><strong>任务描述：</strong></td>
								<td>${schedule.note}</td>
							</tr>
							<tr>
								<td><strong>审核信息：</strong></td>
								<td>${schedule.audit==0?"待审核":""||schedule.audit==1||schedule.audit==2?"通过":"拒绝"}</td>
							</tr>
						</table>
					</div>
					<div>
						<form class="form-horizontal" action="<%=SCHEDULE_AUDIT_URL%>" id="myform" method="post">
							<fieldset>
								<div class="form-group" id="auditDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="destination">审核结论：</label>
									<div class="col-md-5">
										<div class="radio-inline">
											<label><input type="radio" id="audit" name="audit" value="2" checked>
												&nbsp;<span class="text-danger">拒绝</span></label>
										</div> 
										<div class="radio-inline">
											<label><input type="radio" id="audit" name="audit" value="1">
												&nbsp;<span class="text-success">通过</span></label>
										</div> 
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="auditMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="noteDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="note">审核备注：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<textarea id="anote" name="anote" rows="3"
											class="form-control" placeholder="请输入审核所给出的意见信息" rows="10"></textarea>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="noteMsg"></div>
								</div> 
								<div class="form-group">
									<div class="col-md-5 col-md-offset-3">
										<input type="hidden" id="sid" name="sid" value="${schedule.sid}">
										<button type="submit" class="btn btn-primary">增加</button>
										<button type="reset" class="btn btn-warning">重置</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-group" id="news">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h4 class="panel-title"> 
									<a data-toggle="collapse" data-parent="news" href="#contentOne">
										<strong><span class="glyphicon glyphicon-user"></span>&nbsp;出差人员安排（总人数：${schedule.ecount}人）</strong>
									</a>
								</h4>
							</div>
							<div id="contentOne" class="panel-collapse collapse in">
								<div class="panel-body">
									<table class="table table-condensed">
										<thead>
											<tr>
												<th class="text-center"><strong>照片</strong></th>
												<th class="text-center"><strong>姓名</strong></th>
												<th class="text-center"><strong>联系电话</strong></th>
												<th class="text-center"><strong>工资</strong></th>
												<th class="text-center"><strong>级别</strong></th>
												<th class="text-center"><strong>雇佣日期</strong></th>
												<th class="text-center"><strong>部门</strong></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${empList}" var="vo">
												<tr id="travel-${vo.eid}">
													<td class="text-center">
														<img src="upload/emp/${vo.photo}" style="width:20px;"/> 
													</td>
													<td class="text-center"><span id="eid-${vo.eid}" style="cursor:pointer;">${vo.ename}</span></td>
													<td class="text-center">${vo.phone}</td>
													<td class="text-center">￥${vo.salary}</td>
													<td class="text-center">${levelMap[vo.lid]}</td>
													<td class="text-center">${vo.hiredate}</td>
													<td class="text-center">${deptMap[vo.did]}</td>
												</tr> 
											</c:forEach>	
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer" style="height:80px;">
					<jsp:include page="/pages/plugins/include_alert.jsp"/>
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/info/emp_info_modal.jsp"/>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
