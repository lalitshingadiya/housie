var app = angular.module('eventApp', ['ui.bootstrap']);
app.controller('eventController', function($scope, $http,$compile,$filter) {
    $scope.dateformat = 'MM/dd/yyyy';
    $scope.eventList=[];
    $scope.appName="/housie";
    $scope.event={
        eventDate:"",
        eventName:"",
        maximumticket:"0",
        priceperticket:"0",
        status:"Not started"
    };

    /*$scope.loadData=function(pageno){
        var urlName=$scope.appName+"/Event/getAll";
        $scope.ajax(urlName,null,"GET",$scope.loadDataSuccess,$scope.AjaxErrorMessage);

    }*/

    $scope.setModal=function(val){
        $('#exampleModal').modal(val);
        $scope.errorList = {eventDate:'',name:''};
        $scope.event.eventName = '';
        $scope.event.eventDate = '';
        $scope.event.maximumticket = '';
        $scope.event.priceperticket = '';
        $scope.event.Status = '';
     }
    $scope.saveEvent=function(val){

        $scope.checkEmpty($scope.event.eventDate,"Event Date");
        $scope.checkEmpty($scope.event.eventName,"Event Name");
        $scope.checkEmpty($scope.event.maximumticket,"Maximum Ticker Per User");
        $scope.checkEmpty($scope.event.priceperticket,"Price Per Ticket");
        $scope.checkEmpty($scope.event.status,"Status");
        var urlName=$scope.appName+"/event/save";

        var eventObj={
            name:$scope.event.eventName,
            eventDate:$filter('date')($scope.event.eventDate,$scope.dateformat),
            noOfTickets: $scope.event.maximumticket,
            pricePerTicket: $scope.event.priceperticket,
            status:$scope.event.status
        };
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $scope.ajax(urlName,eventObj,"POST",$scope.successMessage,$scope.AjaxErrorMessage);
    };
    $scope.successMessage=function(response){
        console.log(response);
        if(response.data.status==='fail'){
            var errorList = response.data.errorList;
            for(var i=0;i<errorList.length;i++){
                $scope.errorList[errorList[i]['field']] = errorList[i].defaultMessage;
            }

        }else{
            $scope.setModal('hide');
            $('#tbleventlist').DataTable().draw();
            //$scope.loadData(1);
        }


    }
    $scope.loadDataSuccess=function(response){

        $scope.eventList = response.data.data;
        //var table = $('#example').DataTable();
        //table.page( 'next' ).draw( 'page' );

    };
    $scope.AjaxErrorMessage=function(response){
        if(response.status==404){
            alert("Requested Page not found ");
        }else if(response.status==403){
            alert("Internal server error.");
        }
    };
    $scope.checkEmpty=function(htmlId,htmlcontrolname){
        if(angular.isUndefined(htmlId) || htmlId==null || $.trim(htmlId).length<=0 ){
            alert("Please select "+htmlcontrolname+" ");
            return false;
        }
        return true;
    };
    $scope.handleAjaxErrorLoc=function(xhr,textstatus,err){
        console.log(err);
        console.log(xhr);
        console.log(textstatus);

    };
    angular.element(document).ready(function () {
       //$scope.loadData(1);
        //$('#tbleventlist').DataTable();
        $('#tbleventlist').DataTable({
            "pagingType": "full_numbers",
            "processing": true,
            "serverSide": true,
            "ordering": false,
            "ajax": $scope.appName+"/event/getAll",
            error: function (xhr, error, code)
            {
                console.log(xhr);
                console.log(code);
            },
            "lengthMenu": [[5,10, 25, 50, -1], [5,10, 25, 50, "All"]],
            "columns": [
                { "data": "name" },
                { "data": "eventDate" },
                { "data": "noOfTickets" },
                { "data": "pricePerTicket" },
                { "data": "soldTicket" },
                { "data": "noOfUsers" },
                { "data": "status" }
            ]
        });

        let elm =  angular.element(" <button type='button' class='btn btn-primary' data-toggle='modal' ng-click='setModal(\"show\")'>Add</button>")
        let button_Component = $compile(elm)($scope);
        $("#tbleventlist_filter").append(button_Component);

    });
    $scope.clear = function() {
        $scope.event.eventDate = null;
    };

    $scope.inlineOptions = {
         minDate: new Date(),
        showWeeks: false
    };

    $scope.dateOptions = {
        formatYear: 'yyyy',
        startingDay: 1
    };
    $scope.open1 = function() {
        $scope.popup1.opened = true;
    };
    $scope.popup1 = {
        opened: false
    };
    $scope.ajax=function(url,param,methodtype,successCallback,errorCallback){

        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        if(methodtype=="POST"){

            $http({
                url: url,
                method: "POST",
                params: param,
                headers: {
                    'X-CSRF-TOKEN':$("meta[name='_csrf']").attr("content")
                }
            }).then(function (response) {
                successCallback(response);
            }, function (response) {
                errorCallback(response);
            });

        }else{
            $http.get(url)
                .then(function(response) {
                    successCallback(response);
                });
        }
    };

});