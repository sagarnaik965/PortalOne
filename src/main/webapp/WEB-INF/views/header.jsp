<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<%
//START : Fix for Action Spoofing (Clickjacking)
response.addHeader("X-FRAME-OPTIONS", "DENY");
//END : Fix for Action Spoofing (Clickjacking)	 
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", -1);
// 	 set x-xss-protection to 1 
response.setHeader("x-xss-protection", "0");
response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
/* response.setHeader("Access-Control-Allow-Origin", "https://epramaan.in:4007"); */
response.setHeader("X-Download-Options", "noopen");
response.setHeader("X-Content-Security-Policy",
		"default-src 'self'; script-src 'self' cdnjs.cloudflare.com maxcdn.bootstrapcdn.com cdn.jsdelivr.net ajax.googleapis.com; style-src 'self' maxcdn.bootstrapcdn.com cdnjs.cloudflare.com; img-src 'self'; font-src cdnjs.cloudflare.com");
%>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>IOCL</title>

<!-- Bootstrap Core CSS -->
<c:url value="/resources/" var="resources" />
<link href="${resources}dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${resources}vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">
<link href="${resources}dist/css/sb-admin-2.css" rel="stylesheet">
<link href="${resources}vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="${resources}dist/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link href="${resources}dist/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<c:url value="/resources/css/header.css" var="headercss" />
<link href="${headercss }" rel="stylesheet" type="text/css">
</head>

<body>
	<c:url value="/resources/images/cdac.jpg" var="ceglogo" />
	<div id="wrapper">
		<div id="header" style="background-color: white;">
			<nav class="navbar navbar-static-top ep-main-header"
				style="border: 0px; background-color: #fefefe; min-height: 60px"
				role="navigation">
				<div class="container-fluid">
					<div class="navbar-header pull-left">
						<a class="navbar-brand" href='<c:url value ="/home"/>'> <img
							src="${ceglogo}" alt="CeG Logo"
							style="height: 66px; width: 94px;">
						</a>
					</div>
				</div>
			</nav>

			<div class="container-fluid"
				style="padding-left: 0px; padding-right: 0px;">
				<hr
					style="display: block; border: 0; border-top: 5px solid #3e76b9; padding: 0; margin-top: 5px; margin-bottom: 5px;">
			</div>
			
			
			
			
			
			
			
			

			<div id="content">
				<!-- Navigation -->
				<nav class="navbar navbar-default navbar-static-top"
					role="navigation"
					style="margin-bottom: 0; min-height: 30px; border: 0px solid; background-color: #eee;">
				</nav>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				
				
				
				
				
				
				
				<!-- /.navbar-header -->

				<sec:authorize access="isAuthenticated()">
					<ul class="nav navbar-top-links navbar-right">

						<li style="padding-right: 5px;">Welcome <b><sec:authentication
									property="principal.username" /></b> (<b><sec:authentication
									property="principal.tenant" /></b>)
						</li>


						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"
							style="padding: 5px; min-height: 35px;"> <i
								class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href='<c:url value ="/profile"/>'><i
										class="fa fa-user fa-fw"></i> User Profile</a></li>

								<li class="divider"></li>
								<li><a href='#'
									onclick="document.getElementById('logout').submit();"><i
										class="fa fa-sign-out fa-fw"></i> Logout</a></li>
							</ul></li>

						<!-- /.dropdown -->
					</ul>
					<c:url var="logoutUrl" value="/logout" />
					<form action="${logoutUrl}" id="logout" method="post">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<!-- /.navbar-top-links -->

					<div class="navbar-default sidebar" role="navigation"
						style="margin-top: 36px">
						
						<div class="sidebar-nav navbar-collapse">
						
							<ul class="nav" id="side-menu">
								<li><a href='<c:url value ="/home"/>'><i
										class="fa fa-home"></i> Home</a></li>



								<li><a href="#" /> <i class="fa fa-user fa-fw"></i>
									Profile<span class="fa arrow"></span></a>
									<ul class="nav nav-second-level">

										<sec:authorize access="hasAuthority('UPDATE_PROFILE')">
											<li><a href='<c:url value ="/profile"/>'>Update
													Profile</a></li>
										</sec:authorize>

										<li><a href='<c:url value ="/password"/>'>Update
												Password</a></li>

									</ul></li>
								<sec:authorize
									access="hasAuthority('USER_CREATION') or hasAuthority('GENERATE_SA_LICENSE_KEY')or hasAuthority('GENERATE_SA_CODE') or  hasAuthority('MANAGE_SA') or  hasAuthority('SUSPEND_SA') or hasAuthority('RESEND_ACCOUNT_ACTIVATION_LINK')">
									<li><a href="#"><i class="fa fa-gear fa-fw"></i> APP
											Management <span class="fa arrow"></span></a>
										<ul class="nav nav-second-level">

											<sec:authorize access="hasAuthority('USER_CREATION')">
												<li><a href='<c:url value ="/usercreate"/>'>User
														Creation</a></li>
											</sec:authorize>

											<sec:authorize
												access="hasAuthority('GENERATE_SA_LICENSE_KEY')">
												<li><a href='<c:url value ="/asa/generatelk"/>'>Generate
														APP License Key </a></li>
											</sec:authorize>
											<sec:authorize access="hasAuthority('GENERATE_SA_CODE')">
												<li><a href='<c:url value ="/asa/generateSACode"/>'>Generate
														SA Code </a></li>
											</sec:authorize>
											<%-- <sec:authorize access="hasAuthority('MANAGE_SA')">
													<li><a href='<c:url value ="/asa/userstatus"/>'>Manage
															SA</a></li>
												</sec:authorize>
												
												<sec:authorize access="hasAuthority('SUSPEND_SA')">
													<li><a href='<c:url value ="/asa/suspendaua"/>'>Suspend
															SA</a></li>
												</sec:authorize> --%>
											<sec:authorize
												access="hasAuthority('RESEND_ACCOUNT_ACTIVATION_LINK')">
												<!--	<li><a href='<c:url value ="/asa/resendactivation"/>'>Resend
		   															 Account Activation link</a></li> -->
											</sec:authorize>
										</ul></li>

								</sec:authorize>

								<sec:authorize
									access="hasAuthority('UPDATE_AUA_LICENSE_KEY') or hasAuthority('UPDATE_KUA_LICENSE_KEY') or hasAuthority('UPDATE_SA_LICENSE_KEY')">
									<li><a href="#" /> <i class="fa fa-key"></i> Licence Keys<span
										class="fa arrow"></span></a>
										<ul class="nav nav-second-level">
											<%-- <sec:authorize
													access="hasAuthority('UPDATE_AUA_LICENSE_KEY')">
													<li><a href='<c:url value ="/asa/getasalk"/>'>Update
															AUA License key</a></li>
												</sec:authorize>

												<sec:authorize
													access="hasAuthority('UPDATE_KUA_LICENSE_KEY')">
													<li><a href='<c:url value ="/asa/getksalk"/>'>Update
															KUA License key</a></li>
												</sec:authorize> --%>
											<sec:authorize access="hasAuthority('UPDATE_SA_LICENSE_KEY')">
												<li><a href='<c:url value ="/asa/updatesalk"/>'>Update
														APP License Key </a></li>
											</sec:authorize>
										</ul> <!-- /.nav-second-level --></li>
								</sec:authorize>


								<sec:authorize
									access="hasAuthority('TRANSACTION_SPECIFIC_REPORT') or hasAuthority('TRANSACTION_SUMMARY_REPORT_AUA') or hasAuthority('TRANSACTION_SUMMARY_REPORT_SA')">
									<li><a href="#" /> <i class="fa fa-list-alt fa-fw"></i>
										Report<span class="fa arrow"></span></a>
										<ul class="nav nav-second-level">
											<!-- <sec:authorize
													access="hasAuthority('TRANSACTION_SPECIFIC_REPORT')">
													<li><a
														href='<c:url value ="/aua/gettransactiondetailpage"/>'><i
															class="fa fa-file-text fa-fw"></i> Transaction Specific
															Report</a></li>
												</sec:authorize> -->

											<sec:authorize
												access="hasAuthority('TRANSACTION_SUMMARY_REPORT_AUA') or hasAuthority('TRANSACTION_SUMMARY_REPORT_SA')">
												<li><a href='<c:url value ="/reports"/>'><i
														class="fa fa-file-text fa-fw"></i>Transaction Summary</a></li>
											</sec:authorize>
											<sec:authorize
												access="hasAuthority('TRANSACTION_SUMMARY_REPORT_ASA') or hasAuthority('TRANSACTION_SUMMARY_REPORT_AUA')">
												<li><a href='<c:url value ="/txnreports"/>'><i
														class="fa fa-file-text fa-fw"></i>Transactions Details
														Report </a></li>
											</sec:authorize>


										</ul> <!-- /.nav-second-level --></li>
								</sec:authorize>

								<%-- <sec:authorize access="hasAuthority('WEBCLIENT_OPERATIONS')">	
										
										<li><a href="#" /> <i class="glyphicon glyphicon-qrcode"></i>
											Web Client<span class="fa arrow"></span></a>
											<ul class="nav nav-second-level">
													<li ><a
														href='<c:url value ="/client/wchome"/>'><i
															class="" ></i> Online</a></li>
												
													<li><a href='<c:url value ="/client/wcofflinehome"/>'><i
															class=""></i>Offline</a></li>
											</ul> <!-- /.nav-second-level -->
										</li>
										</sec:authorize> --%>
								<sec:authorize access="hasAuthority('VAULT_OPERATIONS')">

									<li><a href="#" /> <i
										class="glyphicon glyphicon-briefcase"></i> Vault Operations<span
										class="fa arrow"></span></a>
										<ul class="nav nav-second-level">
											<li><a href='<c:url value ="/store_uid"/>'><i
													class=""></i>Store UID</a></li>
											<li><a href='<c:url value ="/get_uid"/>'><i class=""></i>Get
													UID</a></li>
											<li><a href='<c:url value ="/get_ref"/>'><i class=""></i>Get
													Reference Number</a></li>
										</ul></li>
								</sec:authorize>

								<sec:authorize access="hasAuthority('BATCH_OPERATIONS')">

									<li><a href="#" /> <i
										class="glyphicon glyphicon-hourglass"></i> Batch Operations<span
										class="fa arrow"></span></a>
										<ul class="nav nav-second-level">
											<li><a href='<c:url value ="/client/wchome"/>'><i
													class=""></i>Upload File</a></li>
											<li><a href='<c:url value ="/client/wcofflinehome"/>'><i
													class=""></i>Get Status</a></li>
										</ul></li>
								</sec:authorize>

								<sec:authorize access="hasAuthority('DOWNLOAD_SECTION')">
									<li><a href='<c:url value ="/downloads"/>'><i
											class="fa fa-download fa-fw"></i> Downloads</a></li>
							</ul>
				</sec:authorize>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		</sec:authorize>

		<!-- /.navbar-static-side -->
		</nav>
	</div>
</body>
</html>
