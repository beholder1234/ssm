/**
 * Created by arao on 2015/12/24.
 */
/* 侧栏导航条 */
function menu1(dx, dx1, dx3) {
    var urla = window.location.href;
    tmp = urla.split("/");
    wza = tmp[tmp.length - 1];
    wza = wza.split("?")[0];
    $(dx).slideDown();
    $("a.nav_top_item").removeClass("hover");
    $(dx3).addClass("hover").siblings().removeClass("hover");
    $(".aside ul li a").each(function () {
        var href = $(this).attr("href");
        if ($(this).attr("href") == wza) {
            $(this).parent().addClass("current");
        }else {
            $(this).parent().removeClass("current");
        }
    })
}
/* END 侧栏导航条 */