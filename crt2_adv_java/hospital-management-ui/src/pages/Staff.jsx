import { useState } from 'react';
import { mockDoctors } from '../data/mockData';
import { Stethoscope, GraduationCap } from 'lucide-react';

const Staff = () => {
  const [staff, setStaff] = useState(mockDoctors);

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '2rem' }}>
        <h1 style={{ fontSize: '1.5rem', margin: 0 }}>Staff Directory</h1>
        <button className="btn btn-primary">Add Staff Member</button>
      </div>

      <div className="grid grid-cols-2">
        {staff.map(member => (
          <div key={member.id} className="card" style={{ display: 'flex', gap: '1.5rem', alignItems: 'flex-start' }}>
            <div style={{
              padding: '1rem',
              borderRadius: 'var(--radius-md)',
              backgroundColor: member.isIntern ? 'rgba(37, 99, 235, 0.1)' : 'rgba(16, 185, 129, 0.1)',
              color: member.isIntern ? 'var(--primary-color)' : 'var(--success-color)'
            }}>
              {member.isIntern ? <GraduationCap size={32} /> : <Stethoscope size={32} />}
            </div>
            
            <div style={{ flex: 1 }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '0.5rem' }}>
                <h3 style={{ margin: 0, fontSize: '1.125rem' }}>{member.name}</h3>
                <span className={`badge ${member.isIntern ? 'badge-primary' : 'badge-success'}`}>
                  {member.isIntern ? 'Intern' : 'Senior Doctor'}
                </span>
              </div>
              
              <div style={{ color: 'var(--text-secondary)', fontSize: '0.875rem', marginBottom: '1rem' }}>
                ID: #{member.id}
              </div>
              
              <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '0.5rem', fontSize: '0.875rem' }}>
                <div>
                  <span style={{ color: 'var(--text-secondary)' }}>Department:</span>
                  <div style={{ fontWeight: 500 }}>{member.department}</div>
                </div>
                <div>
                  <span style={{ color: 'var(--text-secondary)' }}>Specialization:</span>
                  <div style={{ fontWeight: 500 }}>{member.specialization}</div>
                </div>
                {member.isIntern && (
                  <div style={{ gridColumn: 'span 2' }}>
                    <span style={{ color: 'var(--text-secondary)' }}>Duration:</span>
                    <div style={{ fontWeight: 500 }}>{member.duration} Months</div>
                  </div>
                )}
              </div>

              <div style={{ marginTop: '1.5rem', display: 'flex', gap: '0.5rem' }}>
                <button className="btn btn-outline" style={{ flex: 1 }}>View Schedule</button>
                <button className="btn btn-outline" style={{ flex: 1 }}>Assign Patient</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Staff;
