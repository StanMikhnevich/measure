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

    <h3>Измерения за текущий час</h3>
    <br>
    <a href="/measure/list/hour/previous" type="button" > Previous </a>
     ______________________
    <a href="/measure/list/hour/next" type="button" > Next </a>
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
