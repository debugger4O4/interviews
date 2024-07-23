import React, { useEffect, useState } from "react";
import "./styles.css";

/*
 * Вывод списка пользователей
 */

export default function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    getInfo();
  }, []);

  const getInfo = async () => {
    try {
      const users = await fetch("https://jsonplaceholder.typicode.com/users");
      let param = await users.json();
      setData(param);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      {data.map((m) => (
        <div key={m.id}>{m.name}</div>
      ))}
    </div>
  );
}
