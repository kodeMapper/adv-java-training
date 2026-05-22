import { useState } from 'react';
import { mockPatients } from '../data/mockData';
import { Plus, UserPlus, Pill, BedDouble, FileText } from 'lucide-react';

const Patients = () => {
  const [patients, setPatients] = useState(mockPatients);

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '2rem' }}>
        <h1 style={{ fontSize: '1.5rem', margin: 0 }}>Patient Management</h1>
        <button className="btn btn-primary"><Plus size={16} /> Admit Patient</button>
      </div>

      <div className="card">
        <div className="table-container" style={{ border: 'none', boxShadow: 'none' }}>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Ward/Bed</th>
                <th>Diseases</th>
                <th>Status</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {patients.map(p => (
                <tr key={p.patientId}>
                  <td>#{p.patientId}</td>
                  <td style={{ fontWeight: 500 }}>{p.patientName}</td>
                  <td>{p.age}</td>
                  <td>{p.ward} - Bed {p.bedNo}</td>
                  <td>
                    <div style={{ display: 'flex', gap: '0.25rem', flexWrap: 'wrap' }}>
                      {p.diseases.map((d, i) => (
                        <span key={i} className="badge badge-neutral" style={{ fontSize: '0.65rem' }}>{d}</span>
                      ))}
                    </div>
                  </td>
                  <td>
                    <span className={`badge ${p.status === 'Admitted' ? 'badge-warning' : 'badge-success'}`}>
                      {p.status}
                    </span>
                  </td>
                  <td>
                    <div style={{ display: 'flex', gap: '0.5rem' }}>
                      <button className="btn btn-outline" style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem' }} title="Assign Staff">
                        <UserPlus size={14} />
                      </button>
                      <button className="btn btn-outline" style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem' }} title="Add Disease">
                        <Pill size={14} />
                      </button>
                      <button className="btn btn-outline" style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem' }} title="Assign Bed">
                        <BedDouble size={14} />
                      </button>
                      <button className="btn btn-outline" style={{ padding: '0.25rem 0.5rem', fontSize: '0.75rem' }} title="Calculate Bill">
                        <FileText size={14} />
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Patients;
