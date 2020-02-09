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
        <legend>выбрать время</legend>
        <form name="time" action="" method="POST">
            First name:<@spring.formInput "inputHourForm.year" "" "text"/>
            First name:<@spring.formInput "inputHourForm.month" "" "text"/>
            First name:<@spring.formInput "inputHourForm.day" "" "text"/>
            First name:<@spring.formInput "inputHourForm.hour" "" "text"/>
            <br>
            <input type="submit" value="Ok"/>
        </form>
    </fieldset>
</div>

</body>
</html>
