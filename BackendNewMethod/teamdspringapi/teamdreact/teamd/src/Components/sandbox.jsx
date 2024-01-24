import React, { useState, useEffect } from "react";
import { pdfjs } from "react-pdf";
// import { Document, Page } from "react-pdf";
import {Document,Page} from "react-pdf";
import axios from "axios";

pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;

const Sandbox = () => {
  const samplePDF = "/PDF/Sample.pdf";
  const [CertificationData, setCertificationData] = useState([]);
  const [enrollment, setEnrollment] = useState([]);
  const [courseData, setcourseData] = useState([]);
  const [userData, setuserData] = useState([]);
  const [instructorData, setinstructorData] = useState([]);
  const [supportData, setsupportData] = useState([]);
  const [BadgeData, setBadgeData] = useState([]);

  useEffect(() => {
    const loadEnrollment = async () => {
      try {
        // always call it like how you call it on postman(json)
        
        // const enrollmentResult = await axios.get("http://localhost:8080/api/enrollments/1");
        // setEnrollment(enrollmentResult.data);

        // const courseResult = await axios.get(`http://localhost:8080/api/courses/${enrollmentResult.data.courseId}`);
        // setcourseData(courseResult.data);

        // const usersResult = await axios.get(`http://localhost:8080/api/users/${enrollmentResult.data.userID}`);
        // setuserData(usersResult.data);

        // const instructorResult = await axios.get(`http://localhost:8080/api/instructors/${enrollmentResult.data.instructorID}`);
        // setinstructorData(instructorResult.data);

        // const supportResult = await axios.get(`http://localhost:8080/api/supports/${enrollmentResult.data.supportID}`);
        // setsupportData(supportResult.data);

        // const BadgeResult = await axios.get("http://localhost:8080/api/badges/2");
        // setBadgeData(BadgeResult.data);

        const certificationResult = await axios.get("http://localhost:8080/api/certifications/1");
        setCertificationData(certificationResult.data);

        const courseResult = await axios.get(`http://localhost:8080/api/courses/${certificationResult.data.courseId}`);
        setcourseData(courseResult.data);

        const usersResult = await axios.get(`http://localhost:8080/api/users/${certificationResult.data.userID}`);
        setuserData(usersResult.data);

        const instructorResult = await axios.get(`http://localhost:8080/api/instructors/${certificationResult.data.instructorID}`);
        setinstructorData(instructorResult.data);

        const BadgeResult = await axios.get(`http://localhost:8080/api/badges/${certificationResult.data.badgeID}`);
        setBadgeData(BadgeResult.data);

      } catch (error) {
        console.error("Error fetching course data:", error);
      }
    };
    loadEnrollment();
  }, []);

  console.log(CertificationData);
  return (
    <div>
      {/* <div className="cert_con">
        <Document file={samplePDF}>
          <Page pageNumber={1} renderTextLayer={false} />
        </Document>
      </div> */}
      {/* <h1>Enrollment ID: {enrollment.enrollmentID}</h1>
      <h1>User: {userData.full_name}</h1>
      <h1>Course Title: {courseData.title}</h1>
      <h1>Instructor: {instructorData.full_name}</h1>
      <h1>Enrollment Date: {enrollment.enrollmentDate}</h1>
      <h1>Cancelled: {enrollment.cancelled}</h1>
      <h1>Cancellation Reason: {enrollment.cancellationReason}</h1>
      <h1>Support: {supportData.full_name}</h1> */}
      {/* <h1>test: {BadgeData.badgeID}</h1>
      <h1>test: {BadgeData.badge_image}</h1>
      <h1>test: {BadgeData.badge_name}</h1> */}
      {/* <h1>CertID: {CertificationData.certificateID}</h1>
      <h1>Certificate Serial No: {CertificationData.certificateSerialNo}</h1>
      <h1>Course Title: {courseData.title}</h1> 
      <h1>Instructor: {instructorData.full_name}</h1>
      <h1>User: {userData.full_name}</h1>
      <h1>Date Issued: {CertificationData.dateIssued}</h1>
      <h1>Criteria: {CertificationData.criteria}</h1>
      <h1>Badge Image: {BadgeData.badge_image}</h1> */}
    </div>
  );
};

export default Sandbox;