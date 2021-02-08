// 유효성 검토
function isVaildContents(contents) {
    if (contents == '') {
        alert('내용을 입력해주세요!');
        return false;
    }
    if (contents.trim().length > 140) {
        alert('140자 이하로 입력해주세요!');
        return false;
    }
    return true;
}

//익명 username 생성
function getRandomName(length) {
    let result = '';
    let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwzyx123456789';
    let charactersLenght = characters.length;
    for (let i = 0; i < length; i++) {
        let number = Math.random() * charactersLenght;
        let index = Math.floor(number);
        result += characters.charAt(index);
    }
    return result;
}

function editPost(id) {
    showEdits(id);
    let contents = $(`#${id}-contents`).text().trim();
    $(`#${id}-textarea`).val(contents)
}

function showEdits(id) {
    $(`#${id}-editarea`).show();
    $(`#${id}-submit`).show();
    $(`#${id}-delete`).show();


    $(`#${id}-contents`).hide();
    $(`#${id}-edit`).hide();
}

function hideEdits(id) {
    $(`#${id}-editarea`).hide();
    $(`#${id}-submit`).hide();
    $(`#${id}-delete`).hide();


    $(`#${id}-contents`).show();
    $(`#${id}-edit`).show();
}

///////////////////////////////////////////////////////////
$(document).ready(function () {
    getMemos()
})

function getMemos() {
    $('#cards-box').empty();
    $.ajax({
        type: 'GET',
        url: '/api/memos',
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let memo = response[i]
                addHtml(memo['id'], memo['username'], memo['contents'], memo['modifiedAt'])
            }
        }
    })
}

function addHtml(id, username, contents, modifiedAt) {
    let tempHtml = `<div class="card">
                        <div class="metadata">
                            <div class="date">${modifiedAt}</div>
                            <div class="username" id="${id}-username">${username}</div>
                        </div>
                        <div class="contents">
                            <div id="${id}-contents" class="text">${contents}</div>
                            <div id="${id}-editarea" class="edit">
                                <textarea name="" class="te-edit" id="${id}-textarea" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <div class="footer">
                            <img id="${id}-edit" class="icon-edit" src="images/edit.png" alt="" onclick="editPost(${id})">
                            <img id="${id}-delete" class="icon-delete" src="images/delete.png" alt="" onclick="deleteOne(${id})">
                            <img id="${id}-submit" class="icon-submit" src="images/done.png" alt="" onclick="submitEdit(${id})">
                        </div>
                    </div>`
    $('#cards-box').append(tempHtml);
}

function writeMemo() {
    let contents = $('#contents').val();
    if (isVaildContents(contents) == false) {
        return;
    }
    let username = getRandomName(10);
    let data = {'username': username, 'contents': contents}

    $.ajax({
        type: 'POST',
        url: '/api/memos',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지 작성에 성공했습니다!')
            window.location.reload();
        }
    })
}

function submitEdit(id) {
    let contents = $(`#${id}-textarea`).val().trim();
    let username = $(`#${id}-username`).text().trim();

    if (isVaildContents(contents) == false) {
        return;
    }
    let data = {'username': username, 'contents': contents}

    $.ajax({
        type: 'PUT',
        url: `/api/memos/${id}`,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지 수정에 성공했습니다!')
            window.location.reload();
        }
    })
}

function deleteOne(id) {
    $.ajax({
        type: 'DELETE',
        url: `/api/memos/${id}`,
        success: function (response) {
            alert('메시지 삭제에 성공했습니다!')
            window.location.reload();
        }
    })
}