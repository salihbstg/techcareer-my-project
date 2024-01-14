import axios from 'axios';
import './Navbar.css';
const Navbar = ({questions,setQuestions}) => {
  return (
    <div className="navbar flex justify-center items-center gap-28 h-[8%]">
      <a href="#" onClick={async()=>{
        const data=await axios.get("http://localhost:8080/turkish/all");
        console.log(data.data);
      }}>TÜRKÇE</a>
      <a href="#">MATEMATİK</a>
      <a href="#">TARİH</a>
      <a href="#">COĞRAFYA</a>
      <a href="#">GENEL KÜLTÜR</a>
    </div>
  )
}

export default Navbar;
