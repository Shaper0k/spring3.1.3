
//вызов метода получения всех юзеров и заполнения таблицы
getAllDevice();

function getAllDevice() {
    $.getJSON("http://localhost:8080/shop/allDevice", function (data) {
        console.log('1) данные с бэка /allDevice: ', JSON.stringify(data))
        let rows = '';
        $.each(data, function (key, device) {
            rows += createRows(device);
        });
        $('#tableAllDevice').append(rows);


    });
}

function createRows(device) {

    let device_data = '<tr id=' + device.id + '>';
    device_data += '<td>' + device.id + '</td>';
    device_data += '<td>' + device.name + '</td>';
    device_data += '<td>' + device.description + '</td>';
    device_data += '<td>' + device.price + '</td>';


    device_data += '</td>' +
        '<td>' + '<input id="btnEdit" value="Edit" type="button" ' +
        'class="btn-info btn edit-btn" data-toggle="modal" data-target="#editModal" ' +
        'data-id="' + device.id + '">' + '</td>' +

        '<td>' + '<input id="btnDelete" value="Delete" type="button" class="btn btn-danger del-btn" ' +
        'data-toggle="modal" data-target="#deleteModal" data-id=" ' + device.id + ' ">' + '</td>';
    device_data += '</tr>';

    return device_data;
}




//Edit device

$(document).on('click', '.edit-btn', function () {
    const device_id = $(this).attr('data-id');
    console.log("editDeviceId: " + JSON.stringify(device_id));
    $.ajax({
        url: '/shop/' + device_id,
        method: 'GET',
        dataType: 'json',
        success: function (device) {
            $('#editId').val(device.id);
            $('#editName').val(device.name);
            $('#editDescription').val(device.description);
            $('#editPrice').val(device.price);

        }
    });
});

$('#editButton').on('click', (e) => {
    e.preventDefault();

    let deviceEditId = $('#editId').val();

    var editDevice = {
        id: $("input[name='id']").val(),
        name: $("input[name='name']").val(),
        description: $("input[name='description']").val(),
        price: $("input[name='price']").val(),

    }

    $.ajax({
        url: '/shop',
        method: 'PUT',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(editDevice),
        success: (data) => {
            let newRow = createRows(data);
            console.log("newRow: " + newRow)
            $('#tableAllDevice').find('#' + deviceEditId).replaceWith(newRow);
            $('#editModal').modal('hide');
            $('#admin-tab').tab('show');
        },
        error: () => {
            console.log("error editDevice")
        }
    });
});

//Delete Device

$(document).on('click', '.del-btn', function () {

    let device_id = $(this).attr('data-id');
    console.log("deviceId: " + JSON.stringify(device_id));

    $.ajax({
        url: '/shop/' + device_id,
        method: 'GET',
        dataType: 'json',
        success: function (device) {
            $('#delId').empty().val(device.id);
            $('#delName').empty().val(device.name);
            $('#delDescription').empty().val(device.description);
            $('#delPrice').empty().val(device.price);


        }
    });
});

$('#deleteButton').on('click', (e) => {
    e.preventDefault();
    let deviceId = $('#delId').val();
    $.ajax({
        url: '/shop/' + deviceId,
        method: 'DELETE',
        success: function () {
            $('#' + deviceId).remove();
            $('#deleteModal').modal('hide');
            $('#admin-tab').tab('show');
        },
        error: () => {
            console.log("error delete device")
        }
    });
});



//Add New Device

$('.newDevice').on('click', () => {

    $('#name').empty().val('')
    $('#description').empty().val('')
    $('#price').empty().val('')
})

$("#addNewDeviceButton").on('click', () => {

    let newDevice = {
        name: $('#name').val(),
        description: $('#description').val(),
        price: $('#price').val(),

    }


    $.ajax({
        url: 'http://localhost:8080/shop',
        method: 'POST',
        dataType: 'json',
        data: JSON.stringify(newDevice),
        contentType: 'application/json; charset=utf-8',
        success: function () {

            $('#tableAllDevice').empty();
            getAllDevice();
            $('#admin-tab').tab('show');
        },
        error: function () {
            alert('error addDevice')
        }
    });
});