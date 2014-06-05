<%
	ui.decorateWith("kenyaemr", "standardPage", [ patient: patient ])
%>

<div class="ke-page-sidebar">
    ${ ui.includeFragment("kenyaemr", "patient/patientSearchForm", [ defaultWhich: "checked-in" ]) }
</div>

<div class="ke-page-content">
	${ ui.decorate("kenyaui", "panel", [ heading: "Karibu" ], "This is an example page added by this module: KenyaEMR Add On Example.") }
    ${ ui.includeFragment("kenyaemr", "patient/patientSearchResults", [ pageProvider: "kenyaemr", page: "clinician/clinicianViewPatient" ]) }
</div>

<script type="text/javascript">
    var jQuery;
    jQuery(function() {
        jQuery('input[name="query"]').focus();
    });
</script>