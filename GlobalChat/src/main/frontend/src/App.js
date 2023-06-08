import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
   const [hello, setHello] = useState('')
   const [message, setMessage] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
    }, []);

  function translate(){
    axios.post('/api/translate',{
      message: message
    })
    .then(response => {
      setHello(response.data.message.result.translatedText)
    })
    .catch(error => console.log(error))

  }

    return (
        <div>
           
            <br></br>
            <textarea  value={message} onChange={(e) => setMessage(e.target.value)}></textarea>
            <br></br>
            <button type="button" onClick={() => translate()} >send</button>
            <br></br>
            번역 입니다 : {hello}
        </div>
    );
}

export default App;