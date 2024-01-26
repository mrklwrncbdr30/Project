// src/components/CertificateGenerator.js

import React, { useState, useEffect } from 'react';
import jsPDF from 'jspdf';
import img from '../assets/certificate-background.png';
import signatureImg from '../assets/Signiture.png';
import axios from 'axios';

// Add the toDataUrl function here
async function toDataUrl(url) {
  return new Promise((resolve, reject) => {
    const img = new Image();
    img.crossOrigin = 'Anonymous';
    img.onload = function () {
      const canvas = document.createElement('canvas');
      const ctx = canvas.getContext('2d');
      canvas.width = img.width;
      canvas.height = img.height;
      ctx.drawImage(img, 0, 0);
      resolve(canvas.toDataURL('image/png'));
    };
    img.onerror = reject;
    img.src = url;
  });
}

function CertificateGenerator() {
  const [CertificationData, setCertificationData] = useState([]);
  const [courseData, setcourseData] = useState([]);
  const [userData, setuserData] = useState([]);
  const [instructorData, setinstructorData] = useState([]);
  const [BadgeData, setBadgeData] = useState([]);
  const [showCertificate, setShowCertificate] = useState(false);

  useEffect(() => {
    const loadCertificationData = async () => {
      try {
        const certificationResult = await axios.get('http://localhost:8080/api/certifications/1');
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
        console.error('Error fetching certification data:', error);
      }
    };
    loadCertificationData();
  }, []);

  async function generateCertificate() {
    try {
      const doc = new jsPDF({
        orientation: 'landscape',
        unit: 'mm',
        format: [297, 210],
      });

      doc.addImage(img, 'PNG', 0, 0, doc.internal.pageSize.getWidth(), doc.internal.pageSize.getHeight());
      doc.setTextColor(162, 123, 66);
      doc.setFont('helvetica');

      doc.setFontSize(35);
      doc.text(`${userData.full_name}`, 140, 108, { align: 'center' });

      doc.setFontSize(20);
      doc.text(`${courseData.title}`, 190, 119, { align: 'center' });
      doc.setTextColor(0, 0, 0);
      doc.text(`${instructorData.full_name}`, 157, 168, { align: 'left' });

      const options = { day: 'numeric', month: 'long', year: 'numeric' };
      const formattedDateIssued = new Date(CertificationData.dateIssued).toLocaleDateString(undefined, options);
      doc.setFontSize(17);
      doc.text(`${formattedDateIssued}`, 148, 128, { align: 'right' });

      const originalDateIssued = new Date(CertificationData.dateIssued).toLocaleDateString();
      doc.setFontSize(10);
      doc.text(`${originalDateIssued}`, 87, 154, { align: 'right' });
      doc.setFontSize(10);
      doc.text(`${CertificationData.certificateSerialNo}`, 96, 158, { align: 'right' });
      doc.text(`${courseData.courseId}`, 75, 163, { align: 'right' });

      const signatureImgDataUrl = await toDataUrl(signatureImg);
      const signatureWidth = 50;
      const signatureHeight = 50;
      const signatureHorizontalPosition = 140 + (228 - 140) / 2 - signatureWidth / 2;
      doc.addImage(signatureImgDataUrl, 'PNG', signatureHorizontalPosition, 135, signatureWidth, signatureHeight);

      console.log('CertificationData:', CertificationData);
      console.log('courseData:', courseData);
      console.log('userData:', userData);
      console.log('instructorData:', instructorData);

      const pdfContent = doc.output('datauristring');
      console.log('PDF Content:', pdfContent);
      setShowCertificate(pdfContent);

      // Save the PDF to local storage with default name
      const customName = `${userData.full_name.replace(/\s+/g, '_')}_${courseData.courseId}_certificate`;
      const pdfData = doc.output('blob');
      const pdfBlob = new Blob([pdfData], { type: 'application/pdf' });
      const pdfUrl = URL.createObjectURL(pdfBlob);
      localStorage.setItem(customName, pdfUrl);
    } catch (error) {
      console.error('Error generating certificate:', error);
    }
  }

  return (
    <div>
      <button onClick={generateCertificate}>Generate Certificate</button>

      {showCertificate && (
        <div>
          {/* Use <embed> tag instead of <iframe> */}
          <embed src={showCertificate} type="application/pdf" width="100%" height="600px" />
        </div>
      )}
    </div>
  );
}

export default CertificateGenerator;
