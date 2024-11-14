# Node.js Express Project

This is a basic Node.js and Express application to mock the backend for preeclampasia project

## Project Structure

├── app.js # Main application file 
├── package.json # Project metadata and dependencies 
└── README.md # Project documentation

## Features

- **Redirection:** Automatically redirects from `/` to `/demo`.
- **Demo Page:** Displays a page with a link to "Simulate iHealth login."
- **Confirmation Page:** Shows a "Done" message to confirm the simulated login action.

## Prerequisites

- **Node.js**: Ensure you have Node.js installed. You can download it from [Node.js](https://nodejs.org/).

## Installation

1. **Clone the repository**:
```
git clone <repository-url>
cd <repository-name>
```

2. **Install dependencies:**
```
npm install
```

## Usage
1. Start the server:

```
node app.js
```

2. Access the application

- Open your browser and go to http://localhost:8080
- You will be redirected to /demo, where you can click "Simulate iHealth Login."
- After clicking, 
    - The app will post sample JSON data to: http://localhost:3000/ihealth-callback
    - You’ll see a "Done" confirmation message.

Here is sample JSON data that is posted.

```
{
  "BPDataList": [
    {
      "BPL": 8,
      "DataID": "14f8df4c325695a709a4de71a3cb74e4",
      "DataSource": "FromDevice",
      "HP": 122,
      "HR": 65,
      "IsArr": 0,
      "LP": 96,
      "LastChangeTime": 1731425443,
      "Lat": 0,
      "Lon": 0,
      "MDate": 1731407469,
      "Note": "",
      "TimeZone": "-0500",
      "measurement_time": "2024-11-12 10:31:09",
      "time_zone": "-05:00"
    },
    {
      "BPL": 9,
      "DataID": "6cfd6937a25b8f9ac42894ccde131399",
      "DataSource": "FromDevice",
      "HP": 121,
      "HR": 63,
      "IsArr": 0,
      "LP": 87,
      "LastChangeTime": 1731429557,
      "Lat": 0,
      "Lon": 0,
      "MDate": 1731411538,
      "Note": "",
      "TimeZone": "-0500",
      "measurement_time": "2024-11-12 11:38:58",
      "time_zone": "-05:00"
    },
    {
      "BPL": 9,
      "DataID": "73e8e11b82a3521dd9aba244ede446fb",
      "DataSource": "FromDevice",
      "HP": 116,
      "HR": 64,
      "IsArr": 0,
      "LP": 88,
      "LastChangeTime": 1731429689,
      "Lat": 0,
      "Lon": 0,
      "MDate": 1731411658,
      "Note": "",
      "TimeZone": "-0500",
      "measurement_time": "2024-11-12 11:40:58",
      "time_zone": "-05:00"
    }
  ],
  "BPUnit": 0,
  "CurrentRecordCount": 3,
  "NextPageUrl": "",
  "PageLength": 50,
  "PageNumber": 1,
  "PrevPageUrl": "",
  "RecordCount": 3
}
```

