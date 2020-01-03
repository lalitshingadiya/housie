<%@ include file="nav.html" %>

<div ng-controller="eventController" ng-app="eventApp">

		<hr/>
		<table id="tbleventlist" class="table table-striped table-bordered table-sm" cellspacing="0">
			<thead>

			<tr>
				<th class="th-sm">Name</th>
				<th class="th-sm">Date</th>
				<th class="th-sm">No. of Tickets Per Person</th>
				<th class="th-sm">Price Per Ticket</th>
				<th class="th-sm">Total tickets sold</th>
				<th class="th-sm">Total Users</th>
				<th class="th-sm"> Status</th>
			</tr>
			</thead>
			<tbody>
			<tr ng-repeat="event in eventList track by $index" id="eventId">
				<td ng-bind="event.name"></td>
				<td ng-bind="event.eventDate"></td>
				<td ng-bind="event.noOfTickets"></td>
				<td ng-bind="event.pricePerTicket"></td>
				<td ng-bind="event.soldTicket"></td>
				<td ng-bind="event.noOfUsers"></td>
				<td ng-bind="event.status"></td>

			</tr>
			</tbody>
		</table>

	<div>
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Event master</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form>
							<div class="form-group">
								<label for="txteventname" class="col-form-label">Event Name:</label>
								<input type="text" class="form-control" id="txteventname" ng-model="event.eventName">
							</div>
							<div class="form-group">
								<label for="txteventdate" class="col-form-label">Event Date:</label>
								<p class="input-group">
									<input type="text" id="txteventdate"  class="form-control"
										  uib-datepicker-popup="{{dateformat}}" ng-model="event.eventDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="dateformat" />
									<span class="input-group-btn">
            						<button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
         							</span>
								</p>


							</div>
							<div class="form-group">
								<label for="txtmaximumticket" class="col-form-label">Maximum Tickets Per Employee</label>
								<input type="text" class="form-control" id="txtmaximumticket" ng-model="event.maximumticket">
							</div>
							<div class="form-group">
								<label for="txtpriceperticket" class="col-form-label">Price Per Ticket</label>
								<input type="text" class="form-control" id="txtpriceperticket" ng-model="event.priceperticket">
							</div>
							<div class="form-group">
								<label for="status" class="col-form-label">Status</label>
								<select class="form-control" id="status" ng-model="event.status">
									<option value="started">Started</option>
									<option value="Not started">Not Started</option>
									<option value="complted">Completed</option>
								</select>

							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" ng-click="saveEvent()">Save</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="tbleventlist1"></div>
	</div>
	<script src="${contextPath}/webjars/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/webjars/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	<script src="${contextPath}/resources/js/EventController.js"></script>

	</body>

</html>