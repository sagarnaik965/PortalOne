<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.io.*,java.util.*" %>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<link  rel="stylesheet"></link>
<link href="resources/css/home.css" ></link>

 <%
         // New location to be redirected
         String site = new String("http://localhost:8080/adv");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
   %>

<div>
<%@ include file="header.jsp"%>
</div>



<div id="page-wrapper" class="example1">

	<div class="jumbotron col-md-8 col-md-offset-2"
		style="margin-top: 16px">
		<p align="center">Welcome</p>
	</div>
	<!-- commented for iocl -->

	<div class="row">
		<div class="col-lg-12">
			<c:choose>
				<c:when test="${not empty failureMessage}">
					<div class="alert alert-danger alert-dismissable" role="alert">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
						${failureMessage}
					</div>
				</c:when>
				<c:when test="${not empty successMessage}">
					<div class="alert alert-success alert-dismissable" role="alert">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
						${successMessage}
					</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	
	
	<!-- <div class="row">
		<div class="col-lg-12"></div>
	</div>
	<div class="row">
		<div class="col-lg-12"></div>
	</div> -->
	<!-- <div class="row"  > -->

	<div class="row" class="col-lg-1" class="div1" align="center">

		<table class="box table table-hover table-condensed w-auto"
			style="width: 65%">
			<thead>
				<%-- <sec:authorize access="hasAuthority('3') or hasAuthority('2')">
						<tr>
							<td colspan="3" bgcolor="#AFD765" style="font-weight: bold;"><lable>
								<a href="admindeptcount" class="text-white">Total Number Of
									Departments:<label id="deptcount"></label>
								</a></lable></td>
						</tr>
					</sec:authorize> --%>
				<tr>
					<th colspan="3" class="text-center">Transactions</th>
				</tr>
				<tr>

					<th style="color: #3e76b9;" class="text-center" bgcolor="#AFD765"
						style="border-right-style: inset;">Successful</th>
					<th style="color: #3e76b9;" class="text-center" bgcolor="#AFD765"
						style="border-right-style: inset;">Unsuccessful</th>
					<th style="color: #3e76b9;" class="text-center" bgcolor="#AFD765">Total</th>
				</tr>
				<tr>
					<td class="text-center" style="border-right-style: inset;"><label
						id="successcount"></label></td>
					<td class="text-center" style="border-right-style: inset;"><label
						id="errorcount"></label></td>
					<td class="text-center"><label id="tcount"></label></td>
				</tr>
				<tr>
					<td colspan="3" class="text-center"><a
						href="/asa/appcodedetails">Click here for more details</a></td>
				</tr>
			</thead>
			<!-- <tbody>
				</tbody> -->

		</table>


		<!-- <div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: #AFD765">
					Total Transactions</div>
				/.panel-heading
				<div class="panel-body">
					<canvas id="piechart" height="75px"></canvas>
				</div>
				/.panel-body
			</div>
			/.panel
		</div> -->
		
		
		<!-- </div> -->
		<div class="row" class="col-lg-1">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<table
					class="box table table-hover table-condensed table-bordered w-auto"
					style="width: 85%">
					<!-- 					<thead style="border: 1pz solid #000000" > -->
					<tr style="border: 1px solid #000000;">
						<!-- <th style="color: #3e76b9;" class="sc">Kind of Authentication</th> -->
						<th class="text-center" style="color: #3e76b9;" class="sc"
							bgcolor="#AFD765">Mode of Operations</th>
						<th class="text-center" class="sc" bgcolor="#AFD765"><a
							style="color: #3e76b9;">Yes</a></th>
						<th class="text-center" class="sc" bgcolor="#AFD765"><a
							style="color: #3e76b9;">No</a></th>
						<th class="text-center" class="sc" style="color: #3e76b9"
							bgcolor="#AFD765"><a style="color: #3e76b9;">Total</a></th>
					</tr>
					<tbody>
						<tr>
							<th class="th-color" width="20%">Store UID</th>
							<td class="text-center"><span id="successstoreuid">1,00,00,000</span></td>
							<td class="text-center"><span id="failurestoreuid">1,00,00,000</span></td>
							<td class="text-center"><span id="totalstoreuid">1,00,00,000</span></td>
						</tr>
						<tr>
							<th width="20%">Get Reference Number</th>
							<td class="text-center"><span id="successgetrefnum">1,00,00,000</span></td>
							<td class="text-center"><span id="failuregetrefnum">1,00,00,000</span></td>
							<td class="text-center"><span id="totalgetrefnum">1,00,00,000</span></td>
						</tr>
						<tr>
							<th width="20%">Get UID</th>
							<td class="text-center"><span id="successgetuid">1,00,00,000</span></td>
							<td class="text-center"><span id="failuregetuid">1,00,00,000</span></td>
							<td class="text-center"><span id="totalgetuid">1,00,00,000</span></td>
						</tr>
						<tr>
							<th width="20%">Activate</th>
							<td class="text-center"><span id="sucessactivate">1,00,00,000</span></td>
							<td class="text-center"><span id="failureactivate">1,00,00,000</span></td>
							<td class="text-center"><span id="totalactivate">1,00,00,000</span></td>
						</tr>
						<tr>
							<th width="20%">Deactivate</th>
							<td class="text-center"><span id="successdeactivate">1,00,00,000</span></td>
							<td class="text-center"><span id="failuredeactivate">1,00,00,000</span></td>
							<td class="text-center"><span id="totaldeactivate">1,00,00,000</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			</div>
			<div class="col-lg-1"></div>
		</div>
		
		
		
		
		<div class="col-lg-10"></div>
		<%-- <div class="row" style="border: 0px solid red">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<sec:authorize access="hasAuthority('2') or hasAuthority('3')">
			</sec:authorize>
		</div>
	</div> --%>

		<!-- /.row -->

		<!-- /.row -->




		<hr>
		<!-- graph -->		
		<!-- /#page-wrapper -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Transactions month wise</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<canvas id="linechart" height="75px""></canvas>
					</div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		
		
		

		<!-- /.row -->
		<!-- <div class="row">
		<div class="col-lg-12">
			<div class="panel panel-custom shadow">
				<hr style="border-color: grey">
				<div class="panel-heading">
					<i class="fa fa-bar-chart-o fa-fw"></i> Transactions of last six
					months:
				</div>
				/.panel-heading
				<div class="panel-body">
					<canvas id="myChart" height="100px"></canvas>
				</div>
				/.panel-body
			</div>
		</div>
	</div> -->
		<!-- /#page-wrapper -->

	</div>
	
	</div>
	
	 </div>

	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/metisMenu/2.7.0/metisMenu.min.js"></script>

	<script src="resources/dist/js/canvasjs.min.js"></script>
	<script type="text/javascript"
		src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

	<script src="resources/dist/js/Chart.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.3/Chart.min.js">
		<script src="resources/dist/js/sb-admin-2.min.js">
	</script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/startbootstrap-sb-admin-2/3.3.7/js/sb-admin-2.min.js"></script>

	<%-- commented for iocl --%>

	<script>
		/* setInterval(function(){
		 window.location.reload(1);
		 }, 30000); */
		 
		 
		$(document)
				.ready(
						function() {

							$
									.ajax({
										url : "homebar",
										type : "GET",
										success : function(result) {
											//alert(result);
											//console.log("homebar"+result);
											obj = JSON.parse(result);
											// 	console.log(result);
											var month = [];
											var dataPointsAuth = [];
											var dataPointsOtp = [];
											var dataPointsKyc = [];
											var dataPointsBfd = [];
											$.each(obj, function(key, value) {
												/*dataPoints.push({
													x: i++,
													y : value,
													label: key*/
												//alert("1");
												//console.log(key);
												//console.log(value);
												month.push(key);
												var valueData = value;
												$.each(valueData, function(key,
														value) {

													if (key == "AUTH")
														dataPointsAuth
																.push(value);
													if (key == "OTP")
														dataPointsOtp
																.push(value);
													if (key == "e-KYC")
														dataPointsKyc
																.push(value);
													if (key == "BFD")
														dataPointsBfd
																.push(value);
												});

											});

											var canvas = document
													.getElementById('myChart');
											var data = {
												//labels: ["January", "February", "March", "April", "May", "June", "July"],
												labels : month,
												datasets : [
														{
															label : "Demo Auth",
															backgroundColor : "rgba(217, 133, 133,0.75)",
															//     borderColor: "rgba(255,0,0,1)",
															borderWidth : 2,

															//data: [65, 59, 20, 81, 56, 55, 40],dataPointsAuth
															data : dataPointsAuth,
														},

														{
															label : "E-KYC",
															backgroundColor : "rgba(59, 148, 211,0.75)",
															// borderColor: "rgba(0,0,192,1)",
															borderWidth : 2,

															//data: [65, 59, 20, 81, 56, 55, 40],dataPointsAuth
															data : dataPointsKyc,
														//data: dataPointsAuth,
														},

												]
											};
											var option = {
												scales : {
													yAxes : [ {
														stacked : false,
														gridLines : {
															display : true,
															color : "rgba(255,99,132,0.2)"
														}
													} ],
													xAxes : [ {
														gridLines : {
															display : false
														}
													} ]
												}
											};

											var myBarChart = Chart.Bar(canvas,
													{
														data : data,
														options : option
													});										/**/

										}

									});
											

							$.ajax({
								url : "deptcount",
								type : "GET",
								success : function(result) {
									//alert(result);
									//console.log(result);
									// 		console.log(result);
									obj = JSON.parse(result);
									// 		console.log(obj);
									$('#deptcount').html(result);

								}

							});

							$.ajax({
								url : "tryme",
								type : "GET",
								success : function(result) {
									//alert(result);
									//console.log(result);
									// 		console.log("this is for try mw::"+result);
									var obj1 = JSON.parse(result);
									//console.log(obj);
									$.each(obj1, function(key, value) {
										/*dataPoints.push({
											x: i++,
											y : value,
											label: key*/
										//alert("1");
										// 										console.log(key);
										// 										console.log(value);
									});
									// 		console.log("try me is ending");
								}

							});

							
									
									
									$.ajax({
										url : "monthlytotaltrans",
										type : "GET",
										success : function(result) {
											//alert(result);
											// 								console.log(result);

											var dataPoints = [];
											var i = 1;
											$.each(result,
													function(key, value) {
														dataPoints.push({
															x : i++,
															y : value,
															label : key
														});
														// 									console.log("Line key"+key);
														// 									console.log("Line value"+value);

													});

											/*   */
											
											
											
											
											var canvas = document
													.getElementById('linechart');
											var dataPoints1 = [];
											var lable1 = [];
											var data1 = [];
											$
													.each(
															result,
															function(key, value) {
																dataPoints1
																		.push(value);
																lable1
																		.push(key);

																data1.push({
																	x : key,
																	y : value,

																});

															});
											
											
											
											// 								console.log("this is lable1-->"+ lable1);
											// 								console.log("this is line count "+ dataPoints1);
											var data = {
												labels : lable1,
												datasets : [ {
													label : "Total transactions",
													fill : false,
													lineTension : 0.1,
													backgroundColor : "rgba(75,192,192,0.4)",
													borderColor : "rgba(75,0,0,1)",
													borderCapStyle : 'butt',
													borderDash : [],
													borderDashOffset : 0.0,
													borderJoinStyle : 'miter',
													pointBorderColor : "rgba(75,192,192,1)",
													pointBackgroundColor : "#fff",
													pointBorderWidth : 1,
													pointHoverRadius : 5,
													pointHoverBackgroundColor : "rgba(75,192,192,1)",
													pointHoverBorderColor : "rgba(220,220,220,1)",
													pointHoverBorderWidth : 2,
													pointRadius : 5,
													pointHitRadius : 10,
													data : dataPoints1,
												} ]
											};

											var option = {
												showLines : true
											};

											var myLineChart = Chart.Line(
													canvas, {
														data : data,
														options : option
													});

											/*    */

										}

									});							
									
									
							$.ajax({
								type : "get",
								url : "homepagecount",
								success : function(data) {
									//console.log(data);
									obj = JSON.parse(data);

									var authcount = 0;
									var kyccount = 0;
									var otpcount = 0;
									var bfdcount = 0;

									if ('auth' in obj) {
										authcount = obj.auth;

									}

									if ('kyc' in obj) {
										kyccount = obj.kyc;

									}

									if ('otp' in obj) {

										otpcount = obj.otp;
									}
									if ('bfd' in obj) {

										bfdcount = obj.bfd;
									}

									/*	$('#authcount').html(authcount);
										$('#kyccount').html(kyccount);
										$('#otpcount').html(otpcount);*/
									$('#sumcount').html(
											eval(otpcount + kyccount
													+ authcount + bfdcount));

									/*  */

									var ctx = document
											.getElementById("piechart")
									//.getContext('2d');
									var myChart = new Chart(ctx, {
										type : 'pie',
										data : {
											labels : [ "DEMO AUTH", "E-KYC" ],
											//labels: ["DEMO AUTH", "OTP", "E-KYC","BFD"],
											datasets : [ {
												backgroundColor : [
														"rgb(214,134,133)",
														"rgb(185,207,145)",
														"rgb(71,149,215)",
														"rgb(	218,165,32)",

												],
												//data: [authcount,otpcount,kyccount,bfdcount],
												data : [ authcount, kyccount ],

											} ]
										}
									});
									//rgb(172, 214, 110)								
									/*   */

								}

							});

							///adfsefcfczdef
							/* $
									.ajax({
										type : "get",
										url : "maplist",
										success : function(data) {
											// 												console.log("bbbb"+data);
											//alert(data.abc.total);
											//	$('#successcount').html(data);},
											//alert(data.demoauth.failure);
											$('#demoauthsuccess').html(
													data.demoauth.success);
											$('#demoauthfailure').html(
													data.demoauth.failure);
											$('#demoauthtotal')
													.html(
															parseInt(data.demoauth.success)
																	+ parseInt(data.demoauth.failure));

											$('#demootpsuccess').html(
													data.demootp.success);
											$('#demootpfailure').html(
													data.demootp.failure);
											$('#demootptotal')
													.html(
															parseInt(data.demootp.success)
																	+ parseInt(data.demootp.failure));

											$('#demofingersuccess').html(
													data.demofinger.success);
											$('#demofingerfailure').html(
													data.demofinger.failure);
											$('#demofingertotal')
													.html(
															parseInt(data.demofinger.success)
																	+ parseInt(data.demofinger.failure));

											$('#demoirissuccess').html(
													data.demoiris.success);
											$('#demoirisfailure').html(
													data.demoiris.failure);
											$('#demoiristotal')
													.html(
															parseInt(data.demoiris.success)
																	+ parseInt(data.demoiris.failure));

											$('#kycotpsuccess').html(
													data.kycotp.success);
											$('#kycotpfailure').html(
													data.kycotp.failure);
											$('#kycotptotal')
													.html(
															parseInt(data.kycotp.success)
																	+ parseInt(data.kycotp.failure));

											$('#kycfingersuccess').html(
													data.kycfinger.success);
											$('#kycfingerfailure').html(
													data.kycfinger.failure);
											$('#kycfingertotal')
													.html(
															parseInt(data.kycfinger.success)
																	+ parseInt(data.kycfinger.failure));

											$('#kycirissuccess').html(
													data.kyciris.success);
											$('#kycirisfailure').html(
													data.kyciris.failure);
											$('#kyciristotal')
													.html(
															parseInt(data.kyciris.success)
																	+ parseInt(data.kyciris.failure));

											$('#otpotpsuccess').html(
													data.otpotp.success);
											$('#otpotpfailure').html(
													data.otpotp.failure);
											$('#otpotptotal')
													.html(
															parseInt(data.otpotp.success)
																	+ parseInt(data.otpotp.failure));

											$('#bfdsuccess').html(data.bfd.success);
											$('#bfdfailure').html(data.bfd.failure);
											$('#bfdtotal')
													.html(
															parseInt(data.bfd.success)
																	+ parseInt(data.bfd.failure));
										},
										error : function(data) {
											alert("something went wrong");
										}
									}); */

							
									
									
									
									$.ajax({
								type : "get",
								url : "homepagesuccesscount",
								success : function(data) {
									// 												console.log(data);
									//alert(data);
									$('#successcount').html(data);
									$('#tcount').html(
											parseInt(data)
													+ parseInt($('#errorcount')
															.html()));
								},
								error : function(data) {
									alert("something went wrong");
								}
							});
									
							$.ajax({
										type : "get",
										url : "homepagetranstable",
										success : function(data) {
											// 										console.log(data);
											//alert(data.demoauth);
											//obj = data;
											//alert(obj);
											$('#totalstoreuid').html(
													data.struid);
											$('#totalgetuid').html(data.getuid);
											$('#totalgetrefnum').html(
													data.getrefnum);
											$('#totalactivate').html(
													data.activate);
											$('#totaldeactivate').html(
													data.deactivate);
											/* $('#kycfinger').html(data.kycfinger);
											$('#kyciris').html(data.kyciris);
											$('#otpotp').html(data.otpotp); */

										}

									});

							$.ajax({
										type : "get",
										url : "getsuccesscount",
										success : function(data) {
											// 										console.log(data);
											//alert(data.demoauth);
											//obj = data;
											//alert(obj);
											$('#successstoreuid').html(
													data.struid);
											$('#successgetuid').html(
													data.getuid);
											$('#successgetrefnum').html(
													data.getrefnum);
											$('#sucessactivate').html(
													data.activate);
											$('#successdeactivate').html(
													data.deactivate);
											/* $('#kycfinger').html(data.kycfinger);
											$('#kyciris').html(data.kyciris);
											$('#otpotp').html(data.otpotp); */

										}

									});

							$
									.ajax({
										type : "get",
										url : "getfailurecount",
										success : function(data) {
											//console.log(data);
											//alert(data.demoauth);
											//obj = data;
											//alert(obj);
											$('#failurestoreuid').html(
													data.struid);
											$('#failuregetuid').html(
													data.getuid);
											$('#failuregetrefnum').html(
													data.getrefnum);
											$('#failureactivate').html(
													data.activate);
											$('#failuredeactivate').html(
													data.deactivate);
											/* $('#kycfinger').html(data.kycfinger);
											$('#kyciris').html(data.kyciris);
											$('#otpotp').html(data.otpotp); */

										}

									});

							$.ajax({
								type : "get",
								url : "totalerrorcount",
								success : function(data) {
									// 									console.log(data);
									//alert(data.demoauth);
									//	obj = data;
									//	alert(obj);
									$('#errorcount').html(data);

									$('#tcount').html(
											parseInt(data)
													+ parseInt($('#successcount')
															.html()));
								}

							});

							//afzafdafd

						});
	</script>
	
	<!-- jQuery -->
     <c:url value="/resources/" var="resources" />
      <script src="${resources}vendor/jquery/jquery.min.js"></script>
     <script src="${resources}vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${resources}vendor/metisMenu/metisMenu.min.js"></script>
	<script src="${resources}dist/js/sb-admin-2.js"></script>
	<script src="${resources}vendor/jquery/jquery.validate.min.js"></script>
 <script src="${resources}js/update_password.js"></script> 


	<%@ include file="footer.jsp"%>