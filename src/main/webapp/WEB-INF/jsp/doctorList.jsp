<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .doctorlist {
        border: 1px solid black;
        border-radius: 15px;
        overflow: auto;
        box-shadow: 0 0 10px inset;
    }

    .doctorInfo {
        border-bottom: 1px solid sandybrown;
    }

    .doctorName {
        cursor: pointer;
    }
</style>
<h2>Doctors</h2>
<div class="view-box">
    <div class="container doctorlist">
    </div>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Edit doctor</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="name">Name:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="fullName" id="name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="email">Email:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="email" name="email" id="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telNumber">Tel number:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telNumber" id="telNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telHome">Home tel:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telHome" id="telHome">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="homeAddress">Home address:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="homeAddress" id="homeAddress">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="prefer">Prefferencies:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="preferential" id="prefer">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lections">Lections:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="lections" id="lections">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="comments">Comments:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="comments" id="comments">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        updateTable();
    });
    function updateTable() {
        $.get("rest/doctors", updateTableByData)
    }
    function updateTableByData(doctorList) {
        var table = $('.doctorlist');
        table.empty();
        for (var d in doctorList) {
            var doctor = doctorList[d];
            var row = $('<div class="doctorInfo">');
            row.append('<h3 class="doctorName"><a onclick="editRow(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h3>');
            row.append($('<a href="mailto:' + doctor.email + '">').text(doctor.email));
            row.append('<br>Tel: ' + doctor.telNumber);
            if (doctor.telHome != "")
                row.append('<br>Home tel: ' + doctor.telHome);
            var specialties = doctor.specialties;
            var specs = $('<div>');
            specs.append('<a href="#" class="specs"><strong>Specialties: </strong></a>');
            for (var i = 0; i < specialties.length; i++) {
                specs.append('<a href="doctors/specialty/' + specialties[i].name + '">' + specialties[i].name + '</a>');
                if (i < specialties.length - 1) specs.append(', ');
            }
            row.append(specs);
            row.appendTo(table);
        }
    }
    var failedNote;
    function closeNoty() {
        if (failedNote) {
            failedNote.close();
            failedNote = undefined;
        }
    }
    function failNoty(event, jqXHR, options, jsExc) {
        closeNoty();
        failedNote = noty({
            text: 'Failed: ' + jqXHR.statusText + "<br>" + jqXHR.responseJSON,
            type: 'error',
            layout: 'center'
        });
    }
    function successNoty(text) {
        closeNoty();
        noty({
            text: text,
            type: 'success',
            layout: 'center',
            timeout: 1000
        });
    }
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
    var form = $('#detailsForm');
    function editRow(id) {
        $.get("rest/doctors/" + id, function (doctor) {
            $.each(doctor, function (key, val) {
                form.find("input[name='" + key + "']").val(val);
            });
            $('#editRow').modal();
        })
    }
    form.submit(function () {
//        $.ajax({
//            type: "POST",
//            url: "rest/doctors",
//            data: form.serialize(),
//            success: function () {
//                $('#editRow').modal('hide');
//                updateTable();
//                successNoty('Saved');
//            }
//        });
        $.post("rest/doctors", form.serialize(), function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        });
        return false;
    });
</script>
