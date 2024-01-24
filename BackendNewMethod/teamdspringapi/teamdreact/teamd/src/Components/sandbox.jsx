import React, { useState, useEffect } from "react";
import { pdfjs } from "react-pdf";
// import { Document, Page } from "react-pdf";
import {Document,Page} from "react-pdf";
import axios from "axios";

pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;

const Sandbox = () => {
  const samplePDF = "/PDF/Sample.pdf";
  const [enrollment, setEnrollment] = useState([]);
  const [courseData, setcourseData] = useState([]);
  const [userData, setuserData] = useState([]);//
  const [instructorData, setinstructorData] = useState([]);
  const [supportData, setsupportData] = useState([]);
  const [CertificationData, setCertificationData] = useState([]);


  useEffect(() => {
    const loadEnrollment = async () => {
      try {
        // always call it like how you call it on postman(json)
        const enrollmentResult = await axios.get("http://localhost:8080/api/enrollments/2");
        setEnrollment(enrollmentResult.data);

        const courseResult = await axios.get(`http://localhost:8080/api/courses/${enrollmentResult.data.courseId}`);
        setcourseData(courseResult.data);

        const usersResult = await axios.get(`http://localhost:8080/api/users/${enrollmentResult.data.userID}`);
        setuserData(usersResult.data);

        const instructorResult = await axios.get(`http://localhost:8080/api/instructors/${enrollmentResult.data.instructorID}`);
        setinstructorData(instructorResult.data);

        const supportResult = await axios.get(`http://localhost:8080/api/supports/${enrollmentResult.data.supportID}`);
        setsupportData(supportResult.data);

        // const certificationResult = await axios.get("http://localhost:8080/api/badges/3");
        // setCertificationData(certificationResult.data);

      } catch (error) {
        console.error("Error fetching course data:", error);
      }
    };
    loadEnrollment();
  }, []);

  // console.log("http://localhost:8080/api/badges");
  console.log(enrollment);
  return (
    <div>
      {/* <div className="cert_con">
        <Document file={samplePDF}>
          <Page pageNumber={1} renderTextLayer={false} />
        </Document>
      </div> */}
      <h1>Enrollment ID: {enrollment.enrollmentID}</h1>
      <h1>User: {userData.full_name}</h1>
      <h1>Course Title: {courseData.title}</h1> 
      <h1>Instructor: {instructorData.full_name}</h1>
      <h1>Enrollment Date: {enrollment.enrollmentDate}</h1>
      <h1>Cancelled: {enrollment.cancelled}</h1>
      <h1>Cancellation Reason: {enrollment.cancellationReason}</h1>
      <h1>Support: {supportData.full_name}</h1>
      <h1>test: {CertificationData.badgeID}</h1>
      <h1>test: {CertificationData.badge_image}</h1>
      <h1>test: {CertificationData.badge_name}</h1>
    </div>
  );
};

export default Sandbox;