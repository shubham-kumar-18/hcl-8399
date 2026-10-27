import React from 'react'

function Registration() {
    const[empId,setEmpId]=React.useState("");
    const[empName,setEmpName]=React.useState("");
    const[empDesignation,setEmpDesignation]=React.useState("");
    const[empStack,setEmpStack]=React.useState("");
    const[empEmail,setEmpEmail]=React.useState("");
    const[empPassword,setEmpPassword]=React.useState("");

   
async function sendData(e) {
    e.preventDefault();

    try {
        const server = await fetch(
            "http://localhost:8080/v1/user/addemp",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    emp_id: Number(empId),
                    emp_name: empName,
                    designation: empDesignation,
                    stack: empStack,
                    empEmail: empEmail,
                    empPassword: empPassword
                })
            }
        );

        const status = await server.text();

        if (!server.ok) {
            throw new Error(status || "Registration failed");
        }

        alert(status);

    } catch (err) {
        console.error("Error:", err);
        alert("Failed to register. Check the backend and console.");
    }
}


  return (
    <div>
      <form onSubmit={sendData}>

    <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input onChange={(e)=>setEmpName(e.target.value)}  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" required/>
    </div>
    
     <div class="form-group">
    <label for="exampleInputEmail1">Emp_ID</label>
    <input onChange={(e)=>setEmpId(e.target.value)}  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Employee Id" required/>
    </div>
    
    <div class="form-group">
    <label for="exampleInputEmail1">Designation</label>
    <input onChange={(e)=>setEmpDesignation(e.target.value)}  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Designation" required/>
    </div>

    <div class="form-group">
    <label for="exampleInputEmail1">Stack</label>
    <input onChange={(e)=>setEmpStack(e.target.value)}  type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Stack" required/>
    </div>

  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input onChange={(e)=>setEmpEmail(e.target.value)}  type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required/>
  </div>


  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input onChange={(e)=>setEmpPassword(e.target.value)}  type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required/>
  </div>


  <button type="submit" className="btn btn-primary">
    Submit
</button>
</form>
    </div>
  )
}

export default Registration

