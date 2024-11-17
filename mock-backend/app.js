// Step 1: Install Express by running:
// npm install express

// Step 2: Create a file, e.g., app.js, and add the following code:

const express = require('express');
const axios = require('axios');
const app = express();
const PORT = 8080;

// Middleware to handle redirection from "/" to "/demo"
app.get('/', (req, res) => {
  res.redirect('/demo');
});

// Route for "/demo" page with a link to simulate login
app.get('/demo', (req, res) => {
  res.send(`
    <html>
      <body>
        <h1>Demo Page</h1>
        <a href="/simulate-login">Simulate iHealth Login</a>
      </body>
    </html>
  `);
});

// Route to handle simulated login and POST JSON data
app.get('/simulate-login', async (req, res) => {
    // Sample JSON data
    const sampleData = {
      BPDataList: [
        {
          BPL: 8,
          DataID: "14f8df4c325695a709a4de71a3cb74e4",
          DataSource: "FromDevice",
          HP: 142,
          HR: 65,
          IsArr: 0,
          LP: 96,
          LastChangeTime: 1731425443,
          Lat: 0,
          Lon: 0,
          MDate: 1731407469,
          Note: "",
          TimeZone: "-0500",
          measurement_time: "2024-11-12 10:31:09",
          time_zone: "-05:00"
        },
        {
          BPL: 9,
          DataID: "6cfd6937a25b8f9ac42894ccde131399",
          DataSource: "FromDevice",
          HP: 131,
          HR: 63,
          IsArr: 0,
          LP: 87,
          LastChangeTime: 1731429557,
          Lat: 0,
          Lon: 0,
          MDate: 1731411538,
          Note: "",
          TimeZone: "-0500",
          measurement_time: "2024-11-12 11:38:58",
          time_zone: "-05:00"
        },
        {
          BPL: 9,
          DataID: "73e8e11b82a3521dd9aba244ede446fb",
          DataSource: "FromDevice",
          HP: 126,
          HR: 64,
          IsArr: 0,
          LP: 88,
          LastChangeTime: 1731429689,
          Lat: 0,
          Lon: 0,
          MDate: 1731411658,
          Note: "",
          TimeZone: "-0500",
          measurement_time: "2024-11-12 11:40:58",
          time_zone: "-05:00"
        }
      ],
      BPUnit: 0,
      CurrentRecordCount: 3,
      NextPageUrl: "",
      PageLength: 50,
      PageNumber: 1,
      PrevPageUrl: "",
      RecordCount: 3
    };
  
    // Send POST request to the external URL
    try {
      const response = await axios.post('http://localhost:3000/ihealth-callback', sampleData, {
        headers: { 'Content-Type': 'application/json' }
      });
  
      // Show confirmation message to the user after successful POST
      res.send(`
        <html>
          <body>
            <h1>Done</h1>
            <p>Your iHealth login simulation is complete.</p>
          </body>
        </html>
      `);
    } catch (error) {
      console.error('Error posting data to iHealth callback:', error);
      res.status(500).send('Failed to simulate iHealth login.');
    }
  });

// Route to handle simulated login and show confirmation
app.get('/test', (req, res) => {
    res.send(`Test page success.`);
  });
  

// Start the server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});