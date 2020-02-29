<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>



<div>
    <fieldset>
        <legend>Bыбрать время</legend>
        <form name="time" action="" method="POST">
            Year:<@spring.formInput "inputForm.year" "" "text"/>
            <br>
            Month:<@spring.formInput "inputForm.month" "" "text"/>
            <br>
            Day:<@spring.formInput "inputForm.day" "" "text"/>
            <br>
            Hour:<@spring.formInput "inputForm.hour" "" "text"/>
            <br>
            <input type="submit" value="Ok"/>
        </form>
    </fieldset>
</div>






    <h3>Измерения за  1 час -  _  </h3>


    <h3>${interval}</h3>

    <br>

    <a href="/web/measure/list/hour/previous" type="button" > Previous </a>
     ______________________
    <a href="/web/measure/list/hour/next" type="button" > Next </a>
    <br>
    <br>
    <#--<a href="/web/measure/list/pick/minutes" type="button" > _____ Усреднить до минуты __ </a>-->
    <br>
    <br>
    <div>

        <table border="3" bgcolor="#f0f8ff">
            <tr>
                <th>Time</th>
                <th>Value</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <#list measures as measure>
                <tr>
                    <td>${measure.dateTime}</td>
                    <td>${measure.pick}</td>
                    <td><a href="">Delete</a></td>
                    <td><a href="">Edit</a></td>
                </tr>
            </#list>
        </table>

    </div>


</body>
</html>
