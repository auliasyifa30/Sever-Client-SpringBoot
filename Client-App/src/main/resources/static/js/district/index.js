let district = new Object();
let table = null;
let id = 0;

$(document).ready(() => {
    getAll();

    $("#DistrictForm").submit((e) => {
        e.preventDefault();
        formValidation(create);
    });
    
    $("#districtUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
});

function getAll() {
    table = $('#DistrictTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/district/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "districtId", name: "District Id", autoWidth: true
            },
            {
                data: "kotakab", name: "Kota_Kabupaten", autoWidth: true
            },
            {
                data: "districtName", name: "District Name", autoWidth: true
            },

            {
                data: "provinceId.provinceName", name: "Province Name", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-district"
                            onclick="getById('${row.districtId}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.districtId}')">
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    this.districtId = id;
    $.ajax({
        url: `/district/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    district = {
        districtId: $("#district-id").val(),
        kotakab: $("#kota-kab").val(),
        districtName: $("#district-name").val(),
        provinceId: {
            provinceId: $("#province-id").val()
        }

    };
    $.ajax({
        url: "/district",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(district),
        success: (res) => {
            table.ajax.reload();
            successAlert("District Created");
            $("#create-district").modal("hide");
        },
        error: (err) => {
            errorAlert("District failed created");
        }
    });
}

function update() {
    district = {
        districtId: $("#districtId").val(),
        kotakab: $("#kotakab").val(),
        districtName: $("#districtName").val(),
        provinceId: {
            provinceId: $("#provinceId").val()
        }
    };

    let id = $("#districtId").val();
    $.ajax({
        url: `/district/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(district),
        success: (res) => {
            table.ajax.reload();
            successAlert("District Updated");
            $("#form-update").modal("hide");
        },
        error: (err) => {
            errorAlert("District failed updated");
        }
    });
}

function deleteById(id) {

    questionAlert("Are you sure?", "Do you want to delete this data?", function () {
        $.ajax({
            url: `/district/${id}`,
            type: 'DELETE',

            success: (res) => {
                table.ajax.reload();
                successAlert("District sucess deleted");
            },
            error: (err) => {
                errorAlert("District failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#districtId").val(data.districtId);
    $("#kotakab").val(data.kotakab);
    $("#districtName").val(data.districtName);
    $("#provinceId").val(data.provinceId);
}

function resetForm() {
    this.id = 0;
    $("#district-id").val("");
    $("#kota-kab").val("");
    $("#district-name").val("");
    $("#province-id").val("");
}
    