import Appointments from "./Elements/Appointments/Appointments"
import Clinics from "./Elements/Clinics/Clinics"
import MedicalNotes from "./Elements/MedicalNotes/MedicalNotes"
import TimeSlots from "./Elements/TimeSlots/TimeSlots"
import ElementsContainer from "./ElementsContainer"


//return props of DashElement component
const elements = [TimeSlots(), Appointments() ,MedicalNotes() , Clinics()]
//create object props and set its children to elements
//pass props to ElementsContainer
const props = {
    children: elements
}

export default function elementsGenerator() {
    return (
        ElementsContainer({...props})
    );
}

