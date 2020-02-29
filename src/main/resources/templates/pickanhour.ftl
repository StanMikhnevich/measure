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

</body>
</html>
