<%@ include file="common/header.jspf"%> 
<%@ include file="common/navigation.jspf"%> 
	<div class="container">
		Add a Todo
		<form:form method="POST" commandName="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>	
				<form:errors path="desc" cssClass="text-warning"/>			
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">TargetDate</form:label>
				<form:input path="targetDate" type="text" class="form-control" required="required"/>	
				<form:errors path="targetDate" cssClass="text-warning"/>			
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>
<%@ include file="common/footer.jspf"%>