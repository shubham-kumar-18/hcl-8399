
import React,{ useState } from 'react'
import { useEffect } from 'react'
function SampleCode() {
  const[counter, setCounter] = useState(20);
  const[pointer, setPointer] = useState(100);

useEffect(() => {
  console.log("Counter ="+ counter);
  console.log("Pointer ="+ pointer);
}, [pointer, counter]);




  function changeCounter(){
    setCounter(counter + 1);
    
  }

function changePointer(){
  setPointer(pointer -2);
}

  return (
    <div>
      <h2>Counter value = {counter}</h2>
      <h2>Pointer value = {pointer}</h2>
      <button onClick={changeCounter}>Increment</button>
      <button onClick={changePointer}>Decrement</button>
    </div>
  )
}

export default SampleCode
