var com = com || {};
com.bhhan = {};
com.bhhan.mybatis = {};
com.bhhan.mybatis.shop = {
    init: function(){

        var self = this;

        $('#store__btn-modify').on('click', function(){
            self.updateShop();
        });

        $('.store__btn-delete').on('click', function(e){
            self.deleteShop(e.target.getAttribute("data-shopNo"));
        });

        $('#store__btn-add').on('click', function(){
            self.addShop();
        });
    },
    addShop: function(){
        var sendData = {
            shopName: $('#shopName').val(),
            shopLocation: $('#shopLocation').val(),
            shopStatus: $('#shopStatus').val()
        };

        $.ajax({
            type: 'POST',
            url: '/shop/add',
            dataType: 'json',
            data: JSON.stringify(sendData),
            contentType: 'application/json;charset=utf-8'
        }).done(function (number) {
            alert(number + '번 글이 추가되었습니다.');
            window.location.href = '/shop/list';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    updateShop: function(){
        var sendData = {
            shopNo: $('#shopNo').val(),
            shopName: $('#shopName').val(),
            shopLocation: $('#shopLocation').val(),
            shopStatus: $('#shopStatus').val()
        };

        $.ajax({
            type: 'PUT',
            url: '/shop/modify',
            dataType: 'json',
            data: JSON.stringify(sendData),
            contentType: 'application/json;charset=utf-8'
        }).done(function (number) {
            alert(number + '번 글이 수정되었습니다.');
            window.location.href = '/shop/list';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    deleteShop: function(shopNo){
        console.log(shopNo);
        $.ajax({
            type: 'DELETE',
            url: '/shop/delete/' + shopNo
        }).done(function (number) {
            alert(number + '번 글이 삭제되었습니다.');
            window.location.href = '/shop/list';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

$(document).ready(function(){
    com.bhhan.mybatis.shop.init();
});
