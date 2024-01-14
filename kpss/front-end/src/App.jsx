import { useState } from "react";
import "./App.css";
import Navbar from "./components/Navbar";
import Turkish from "./components/Turkish";

function App() {
  const[questions,setQuestions]=useState([]);
  return (
    <div className="h-screen w-screen">
      <Navbar questions={questions} setQuestions={setQuestions}></Navbar>
      <h2 className="text-center text-5xl mt-3">TÜRKÇE</h2>
      <Turkish></Turkish>
    </div>
  );
}

export default App;
