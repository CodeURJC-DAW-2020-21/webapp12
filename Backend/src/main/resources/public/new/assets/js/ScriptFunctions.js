

//------------------------------------------------------------------OTHER SYSTEM-------------------------------------------------------------------------


function mark(idproduct) {
    if ($("#product" + idproduct).children().attr("class") == "la la-bookmark") {
        $.post("/addProduct?idproduct=" + idproduct + "&_csrf=" + token, function (data) {
            $("#product" + idproduct).children().attr("class", "la la-check-circle");
        });
    } else {
        $.post("/dropProduct?idproduct=" + idproduct + "&_csrf=" + token, function (data) {
            $("#product" + idproduct).children().attr("class", "la la-bookmark");
        });
    }
}

//------------------------------------------------------BAR SEARCH-------------------------------------------------------------------------

function searchBarProducts() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarPosts() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        a = s.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarUsers() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName("col-lg-3 col-md-4 col-sm-6 col-12");
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("company_profile_info")[0];
        m = s.getElementsByClassName("company-up-info")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchBarCompany() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByClassName("col-lg-3 col-md-4 col-sm-6");
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("company_profile_info")[0];
        m = s.getElementsByClassName("company-up-info")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

//-----------------------------------------------------------------------FILTER----------------------------------------------------------

function clearAllFilter() {
    document.getElementById('word').value = '';
    $('.selectall').attr('checked', false);
    $('.slider-input').attr('value', '5,50');
    $('.high').attr('style', 'left: 149px;');
    $('.pointer.low').attr('style', 'left: 9px;');
    $('.selected-bar').attr('style', 'width: 140px; left: 15.5px;');
    $('.pointer-label.high').text('50');
    $('.pointer-label.low').text('0');
    $('#menu option[value="0"]').attr('selected', true);
}


function clearSlider() {
    $('.slider-input').attr('value', '5,50');
    $('.high').attr('style', 'left: 149px;');
    $('.pointer.low').attr('style', 'left: 9px;')
    $('.selected-bar').attr('style', 'width: 140px; left: 15.5px;')
    $('.pointer-label.high').text('50')
    $('.pointer-label.low').text('0')

}

function SearchKeyWords() {
    var input, filter, ul, li, a, i, txtValue;
    input = document.getElementById('word');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job_descp")[0];
        m = s.getElementsByClassName("skill-tags")[0];
        p = m.getElementsByTagName("li");
        for (x = 0; x < p.length; x++) {
            q = p[x].getElementsByTagName("a")[0];
            a = q.getElementsByTagName("p")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
}


function SearchStatus1() {
    var input, filter, ul, li, a, i, txtValue;
    input = "in stock";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function SearchStatus2() {
    var input, filter, ul, li, a, i, txtValue;
    input = "reserved";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function SearchStatus3() {
    var input, filter, ul, li, a, i, txtValue;
    input = "sold";
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[0];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchCity() {
    var input, filter, ul, li, a, i, txtValue;
    input = $("#menu").val();
    filter = input.toUpperCase();
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("epi-sec")[0];
        m = s.getElementsByClassName("descp")[0];
        j = m.getElementsByTagName("li")[1];
        a = j.getElementsByTagName("span")[0];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function searchSlider() {
    var input, filter, ul, li, a, i, txtValue, limits;
    input = $("#sliderInput").val();
    limits = input.split(',');
    filter = range(limits[0], limits[1]);
    ul = document.getElementById("myULS");
    li = ul.getElementsByClassName('post-bar');
    for (i = 0; i < li.length; i++) {
        s = li[i].getElementsByClassName("job-status-bar")[0];
        m = s.getElementsByClassName("col-lg-3")[1];
        a = m.getElementsByTagName("h3")[0];
        txtValue = a.textContent || a.innerText;
        if (filter.includes(txtValue.split(' ')[1])) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}

function range(start, end) {
    var ans = [];
    for (let i = start; i <= end; i++) {
        ans.push('' + i);
    }
    return ans;
}