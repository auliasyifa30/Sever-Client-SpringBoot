let province = new Object();
let table = null;
let id = 0;

$(document).ready(() => {
    getAll();


    $("#provinceForm").submit((e) => {
        e.preventDefault();
        formValidation(create);
    });

    $("#provinceUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
});

function getAll() {
    table = $('#provinceTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/province/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "provinceId", name: "Province Id", autoWidth: true
            },
            {
                data: "provinceName", name: "Province Name", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-province"
                            onclick="getById('${row.provinceId}')"
                        >
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick='deleteById(${row.provinceId})'>
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    this.provinceId = id;
    $.ajax({
        url: `/province/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function create() {
    province = {
        provinceId: $("#provinceId").val(),
        provinceName: $("#provinceName").val()
    };

    $.ajax({
        url: "/province",
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(province),
        success: (res) => {
            table.ajax.reload();
            successAlert("Province Created");
            $("#create-province").modal("hide");
        },
        error: (err) => {
            errorAlert("Province failed created");
        }
    });
}

function update() {
    province = {
        provinceId: $("#province-id").val(),
        provinceName: $("#province-name").val()
    };
    let id = $("#province-id").val();

    $.ajax({
        url: `/province/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(province),
        success: (res) => {
            table.ajax.reload();
            successAlert("Province Updated");
            $("#update-province").modal("hide");
        },
        error: (err) => {
            errorAlert("Province failed updated");
        }
    });
}


function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", function () {
        $.ajax({
            url: `/province/${id}`,
            type: 'DELETE',

            success: (res) => {
                table.ajax.reload();
                successAlert("Province sucess deleted");

            },
            error: (err) => {
                errorAlert("Province failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#province-id").val(data.provinceId);
    $("#province-name").val(data.provinceName);
}

function resetForm() {
    this.id = 0;
    $("#provinceId").val("");
    $("#provinceName").val("");
}