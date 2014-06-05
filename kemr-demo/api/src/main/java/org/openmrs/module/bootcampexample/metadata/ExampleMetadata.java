/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.bootcampexample.metadata;

import org.openmrs.PatientIdentifierType;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

/**
 * Example metadata bundle
 */
@Component
public class ExampleMetadata extends AbstractMetadataBundle {

	public static class _EncounterType {
		public static final String EXAMPLE = "d69dedbd-3933-4e44-8292-bea939ce980a";

        //Early Infant Male Circumcision Encounter
        public static final String INFANT_CIRCUMCISION = "182758e8-e190-11e3-a1ed-2c41385eca5b";
    }

    public static class _PatientIdentifierType{
        //Theatre Register Number as per facility procedures
        public static final String THEATRE_REGISTER_NUMBER = "6581a14c-eaf1-11e3-b77c-2c41385eca5b";
    }

	public static class _Form {
		public static final String EXAMPLE = "b694b1bc-2086-47dd-a4ad-ba48f9471e4b";

        //Enrol Infant Form
        public static final String ENROL = "b9f63d60-e6f9-11e3-ae4a-2c41385eca5b";

        //Medical History and Physical Examination Form
        public static final String MEDHISTORY = "bf43a54e-e192-11e3-9add-2c41385eca5b";

        //Post-Op Follow Up Form
        public static final String FOLLOWUP = "2a969e46-e643-11e3-8761-2c41385eca5b";

        //Circumcision Procedure
        public static final String PROCEDURE = "4f8fd2bc-e6f7-11e3-a84b-2c41385eca5b";
	}

    //Program
    public static class _Program{
        //Voluntary Male Circumcision CLinic
        public static final String VMCC = "fadd19f0-ec9b-11e3-817c-2c41385eca5b";
    }


	/**
	 * @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
        //Encounters
		install(encounterType("Example encounter", "Just an example", _EncounterType.EXAMPLE));
        install(encounterType("Early Infant Male Circumcision", "Infant Circumcision", _EncounterType.INFANT_CIRCUMCISION));

        //Forms
		install(form("Example form", null, _EncounterType.EXAMPLE, "1", _Form.EXAMPLE));
        install(form("Enrol Infant", "Form to enrol infant for circumcision", _EncounterType.INFANT_CIRCUMCISION, "1.0", _Form.ENROL));
        install(form("Medical History and Physical Examination", "Form to collect information about Medical History and Physical Examination during Infant Male Circumcision", _EncounterType.INFANT_CIRCUMCISION, "1.0", _Form.MEDHISTORY));
        install(form("Circumcision Procedure", "Form to collect information about the circumcision procedure", _EncounterType.INFANT_CIRCUMCISION, "1.0", _Form.PROCEDURE));
        install(form("Post-Op Follow Up (for any moderate or severe AE, inform the appropriate supervisor and complete incidence form)", "Follow Up", _EncounterType.INFANT_CIRCUMCISION, "1.0", _Form.FOLLOWUP));

        //Patient Identifiers
        install(patientIdentifierType("Theatre Registration Number","Theatre Registration Number", null, null, null, PatientIdentifierType.LocationBehavior.NOT_USED, false, _PatientIdentifierType.THEATRE_REGISTER_NUMBER));

        //Program
        install(program("VMCC", "Enrol men only", Dictionary.VMCC, _Program.VMCC));
	}
}